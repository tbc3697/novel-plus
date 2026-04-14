package com.java2nb.novel.core.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.function.BiConsumer;

@Slf4j
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // 获取请求基本信息
        String uri = httpRequest.getRequestURI();
        if (uri.contains("/mcp")) {
            chain.doFilter(request, response);
            return;
        }
        String method = httpRequest.getMethod();
        String queryString = httpRequest.getQueryString();


        // 记录开始时间
        long startTime = System.currentTimeMillis();

        try {
            // 执行后续过滤器和目标资源
            chain.doFilter(request, response);
        } finally {
            // 计算并打印耗时
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            BiConsumer<String, String[]> logAction = duration > 100 ? log::error : log::info;
            // 实时打印请求耗时日志
            logAction.accept(
                    "[REQUEST_TIME] {} {} | Status: {} | Params: {} | Duration: {} ms",
                    new String[]{method, uri, String.valueOf(httpResponse.getStatus()), queryString, String.valueOf(duration)}
            );
        }
    }

}
