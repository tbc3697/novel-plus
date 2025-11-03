package com.java2nb.novel.core.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 接口耗时统计过滤器
 */
public class ApiTimeCostFilter implements Filter {

    // 存储接口调用统计信息
    private static final Map<String, ApiStats> apiStatsMap = new ConcurrentHashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化操作
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // 获取请求信息
        String uri = httpRequest.getRequestURI();
        String method = httpRequest.getMethod();
        String apiKey = method + " " + uri;

        // 记录开始时间
        long startTime = System.currentTimeMillis();

        try {
            // 继续执行过滤器链
            chain.doFilter(request, response);
        } finally {
            // 计算耗时
            long endTime = System.currentTimeMillis();
            long costTime = endTime - startTime;

            // 更新统计信息
            updateApiStats(apiKey, costTime);

            // 可选：记录到日志
            logApiCost(apiKey, costTime, httpResponse.getStatus());
        }
    }

    /**
     * 更新接口统计信息
     * @param apiKey 接口标识(方法+URI)
     * @param costTime 耗时(ms)
     */
    private void updateApiStats(String apiKey, long costTime) {
        apiStatsMap.compute(apiKey, (key, stats) -> {
            if (stats == null) {
                return new ApiStats(costTime);
            } else {
                stats.update(costTime);
                return stats;
            }
        });
    }

    /**
     * 记录接口耗时日志
     * @param apiKey 接口标识
     * @param costTime 耗时
     * @param status HTTP状态码
     */
    private void logApiCost(String apiKey, long costTime, int status) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(String.format("[%s] API: %s, Status: %d, Cost: %d ms",
                timestamp, apiKey, status, costTime));
    }

    /**
     * 获取接口统计信息
     * @return 统计信息Map
     */
    public static Map<String, ApiStats> getApiStats() {
        return new ConcurrentHashMap<>(apiStatsMap);
    }

    @Override
    public void destroy() {
        // 清理资源
        apiStatsMap.clear();
    }

    /**
     * 接口统计信息类
     */
    public static class ApiStats {
        private long callCount = 0;      // 调用次数
        private long totalTime = 0;      // 总耗时
        private long maxTime = 0;        // 最大耗时
        private long minTime = Long.MAX_VALUE; // 最小耗时

        public ApiStats(long initialTime) {
            update(initialTime);
        }

        public synchronized void update(long time) {
            callCount++;
            totalTime += time;
            maxTime = Math.max(maxTime, time);
            minTime = Math.min(minTime, time);
        }

        // Getters
        public long getCallCount() { return callCount; }
        public long getTotalTime() { return totalTime; }
        public long getMaxTime() { return maxTime; }
        public long getMinTime() { return minTime; }
        public double getAverageTime() { return callCount > 0 ? (double) totalTime / callCount : 0; }
    }
}