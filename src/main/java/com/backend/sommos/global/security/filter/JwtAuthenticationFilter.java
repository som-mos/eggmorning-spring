package com.backend.sommos.global.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.backend.sommos.global.security.service.inf.JwtService;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private JwtService jwtService;
	private String BEARER_HEADER_PREFIX = "Bearer ";

	public JwtAuthenticationFilter(JwtService jwtService){
		this.jwtService = jwtService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String bearerToken = getAuthorizationBearerToken(request);
	}

	private String getAuthorizationBearerToken(HttpServletRequest request){
		String authorizationHeader = request.getHeader("Authorization");

		if(authorizationHeader != null && !authorizationHeader.equals("") && authorizationHeader.startsWith(BEARER_HEADER_PREFIX)) {
			return authorizationHeader.substring(BEARER_HEADER_PREFIX.length());
		}

		return null;
	}
}
