package com.java2nb.novel.controller;

import com.java2nb.novel.core.bean.UserDetails;
import com.java2nb.novel.core.utils.CookieUtil;
import com.java2nb.novel.core.utils.JwtTokenUtil;
import io.github.xxyopen.model.resp.RestResult;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.function.Supplier;


/**
 * @author 11797
 */
public class BaseController {
    private final List<String> PRIVILEGE_USER_LIST = List.of("admin", "root", "15652283697");

    protected JwtTokenUtil jwtTokenUtil;


    protected boolean privilegeUser(UserDetails user) {
        return user != null && PRIVILEGE_USER_LIST.contains(user.getUsername());
    }

    protected boolean nonPrivilegeUser(UserDetails user) {
        return !privilegeUser(user);
    }

    protected boolean nonPrivilegeUser(HttpServletRequest request) {
        UserDetails user = getUserDetails(request);
        return nonPrivilegeUser(user);
    }

    protected <T> RestResult<List<T>> privilegeRuleRun(HttpServletRequest request, Supplier<List<T>> supplier) {
        if (nonPrivilegeUser(request)) {
            return RestResult.ok(List.of());
        }
        return RestResult.ok(supplier.get());
    }


    protected String getToken(HttpServletRequest request){
        String token = CookieUtil.getCookie(request,"Authorization");
        if(token != null){
            return token;
        }
        return request.getHeader("Authorization");
    }

    protected UserDetails getUserDetails(HttpServletRequest request) {
        String token = getToken(request);
        if(StringUtils.isBlank(token)){
            return null;
        }else{
            return jwtTokenUtil.getUserDetailsFromToken(token);
        }
    }

    @Autowired
    public void setJwtTokenUtil(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }
}
