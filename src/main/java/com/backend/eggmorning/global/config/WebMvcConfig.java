package com.backend.eggmorning.global.config;

import com.backend.eggmorning.global.security.interceptor.JwtInterceptor;
import com.backend.eggmorning.global.security.service.inf.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private JwtService jwtService;

    @Autowired
    public WebMvcConfig(JwtService jwtService){
        this.jwtService = jwtService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor(jwtService));
    }
}
