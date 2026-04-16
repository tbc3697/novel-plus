package com.java2nb.novel.core.filter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.WebUtils;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class McpLoggingInterceptor implements HandlerInterceptor {

    private static final String MCP_ENDPOINT = "/mcp";

    private static final ConcurrentHashMap<String, Long> REQUEST_START_TIMES = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> REQUEST_SUMMARIES = new ConcurrentHashMap<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();

        if (!uri.contains(MCP_ENDPOINT)) {
            return true;
        }

        String requestId = generateRequestId();
        long startTime = System.currentTimeMillis();

        REQUEST_START_TIMES.put(requestId, startTime);

        String method = request.getMethod();
        ContentCachingRequestWrapper wrapper = WebUtils.getNativeRequest(request, ContentCachingRequestWrapper.class);
        String requestBody = extractRequestBody(wrapper);
        String summary = String.format("%s %s | Body: %s", method, uri, truncate(requestBody, 500));
        REQUEST_SUMMARIES.put(requestId, summary);

        response.setHeader("X-MCP-Request-ID", requestId);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String uri = request.getRequestURI();

        if (!uri.contains(MCP_ENDPOINT)) {
            return;
        }

        String requestId = response.getHeader("X-MCP-Request-ID");
        if (requestId == null) {
            return;
        }

        Long startTime = REQUEST_START_TIMES.remove(requestId);
        String summary = REQUEST_SUMMARIES.remove(requestId);

        long duration = startTime != null ? System.currentTimeMillis() - startTime : 0;
        int status = response.getStatus();

        if (ex != null) {
            log.error("[MCP] {} | Status: {} | Duration: {}ms | Error: {}",
                    summary, status, duration, ex.getMessage());
        } else {
            log.info("[MCP] {} | Status: {} | Duration: {}ms", summary, status, duration);
        }
    }

    private String generateRequestId() {
        return "MCP-" + System.currentTimeMillis() + "-" + (int) (Math.random() * 10000);
    }

    private String extractRequestBody(ContentCachingRequestWrapper request) {
        try {

            String contentType = request.getContentType();
            if (contentType == null || !contentType.toLowerCase().contains("application/json")) {
                return "[Non-JSON]";
            }

            byte[] bodyBytes = request.getContentAsByteArray();
            if (bodyBytes.length == 0) {
                return "[Empty]";
            }

            return new String(bodyBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            return "[Read Error]";
        }
    }

    private String truncate(String str, int maxLength) {
        if (str == null) {
            return "null";
        }
        if (str.length() <= maxLength) {
            return str;
        }
        return str.substring(0, maxLength) + "...";
    }
}
