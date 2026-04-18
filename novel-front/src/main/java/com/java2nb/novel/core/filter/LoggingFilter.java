package com.java2nb.novel.core.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.function.BiConsumer;


@Slf4j
public class LoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        long startTime = System.currentTimeMillis();

        try {
            filterChain.doFilter(requestWrapper, responseWrapper);
        } finally {
            String reqBody = "";
            String respBody = "";
            if (uri.startsWith("/mcp")) {
                reqBody = getBody(requestWrapper.getContentAsByteArray());
                respBody = getBody(responseWrapper.getContentAsByteArray());
            }

            // 计算并打印耗时
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            var method = request.getMethod();

            BiConsumer<String, String[]> logAction = duration > 100 ? log::error : log::info;
            // 实时打印请求耗时日志
            logAction.accept(
                    "[REQUEST_TIME] {} {} | Status: {}| Duration: {} ms | Params: {} | respBody: {}",
                    new String[]{method, uri, String.valueOf(response.getStatus()), reqBody, String.valueOf(duration), respBody}
            );
            responseWrapper.copyBodyToResponse();
        }
    }

    private String getBody(byte[] buf) {
        if (buf == null || buf.length == 0) return "";
        if (buf.length > 10240) return "[too large]";
        return new String(buf, StandardCharsets.UTF_8);
    }
}