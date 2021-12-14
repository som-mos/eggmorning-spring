package com.backend.sommos.global.security.interceptor;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.backend.sommos.global.constant.JwtConstant;
import com.backend.sommos.global.constant.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.backend.sommos.global.security.annotation.Public;
import com.backend.sommos.global.security.service.inf.JwtService;

public class JwtInterceptor implements HandlerInterceptor {
    JwtService jwtService;

    @Autowired
    public JwtInterceptor(@Qualifier("JwtService") JwtService jwtService){
        this.jwtService = jwtService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getMethod().equals("OPTION") || ((HandlerMethod)handler).getMethod().isAnnotationPresent(Public.class)){
            return true;
        }

        String token = getAuthorizationToken(request);
        Map<String, Object> claims = jwtService.parseTokenClaim(token);

        UsernamePasswordAuthenticationToken authentication = isRefreshToken(claims)
                ? generateRefreshAuthentication(claims)
                : generateBasicAuthentication(claims);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return true;
    }

    private String getAuthorizationToken(HttpServletRequest request) throws Exception {
        String authorizationHeader = request.getHeader("Authorization");
        if(authorizationHeader == null || authorizationHeader.equals("")){
            throw new Exception();
        }

        String[] headerSplits = authorizationHeader.split(" ");
        if(headerSplits.length == 0 || headerSplits[0] == null || headerSplits[1] == null){
            throw new Exception();
        }

        return headerSplits[1];
    }

    private boolean isRefreshToken(Map<String, Object> claims){
        return (boolean) claims.get(JwtConstant.CLAIM_IS_REFRESH_TOKEN);
    }

    private UsernamePasswordAuthenticationToken generateRefreshAuthentication(Map<String, Object> claims) {
        String email = (String) claims.get(JwtConstant.CLAIM_EMAIL);
        List<SimpleGrantedAuthority> roles = Collections.singletonList(Role.REFRESH.getAuthority());
        return new UsernamePasswordAuthenticationToken(email, null, roles);
    }

    private UsernamePasswordAuthenticationToken generateBasicAuthentication(Map<String, Object> claims) {
        Map<String, Object> user = (Map<String, Object>) claims.get(JwtConstant.CLAIM_USER);
        String email = (String) user.get(JwtConstant.CLAIM_EMAIL);
        List<SimpleGrantedAuthority> roles = ((List<Map<String, Object>>) user.get(JwtConstant.CLAIM_ROLES)).stream()
                .map(role -> (String) role.get("name"))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(email, null, roles);
    }
}
