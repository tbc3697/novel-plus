package com.java2nb.novel.service;

import com.java2nb.novel.core.bean.UserDetails;
import com.java2nb.novel.core.utils.CookieUtil;
import com.java2nb.novel.core.utils.JwtTokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserDetailHolder {
    private static final long S_U_L = 100000000L;

    private HttpServletRequest request;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public String getToken() {
        String token = CookieUtil.getCookie(request, "Authorization");
        if (token != null) {
            return token;
        }
        return request.getHeader("Authorization");
    }

    public Long getUserId() {
        return getUserDetails().getId();
    }

    public UserDetails getUserDetails() {
        String token = getToken();
        if (StringUtils.isBlank(token)) {
            return null;
        } else {
            return jwtTokenUtil.getUserDetailsFromToken(token);
        }
    }

    public Integer getUserCrawlSource() {
        try {
            var userId = getUserId();
            if (userId < S_U_L) {
                return (int) (userId % 1000);
            }
        } catch (Throwable e) {
            log.error("获取用户爬虫源失败:{}", e.getMessage());
        }
        return null;
    }

    @Autowired
    @Scope("prototype")
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

}
