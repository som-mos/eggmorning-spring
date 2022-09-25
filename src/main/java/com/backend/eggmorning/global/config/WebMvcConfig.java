package com.backend.eggmorning.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.backend.eggmorning.global.security.interceptor.JwtInterceptor;
import com.backend.eggmorning.global.security.service.JwtService;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	private JwtService jwtService;

	public WebMvcConfig(JwtService jwtService) {
		this.jwtService = jwtService;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new JwtInterceptor(jwtService));
	}
}
