package com.backend.eggmorning.domain.auth.controller;

import com.backend.eggmorning.domain.auth.dto.BasicAuthentication;
import com.backend.eggmorning.domain.auth.dto.TokenResponse;
import com.backend.eggmorning.domain.auth.service.AuthService;
import com.backend.eggmorning.domain.user.entity.User;
import com.backend.eggmorning.domain.user.service.inf.UserService;
import com.backend.eggmorning.global.network.Response;
import com.backend.eggmorning.global.security.annotation.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	private AuthService authService;
	private UserService userService;

	@Autowired
	public AuthController(AuthService authService, UserService userService){
		this.authService = authService;
		this.userService = userService;
	}

	@Public
	@PostMapping("/auth/login")
	public ResponseEntity<TokenResponse> login(@RequestBody BasicAuthentication authentication){
		User user = this.userService.getUserByEmail(authentication.email);
		if(user == null){
			throw new UsernameNotFoundException(authentication.email);
		}

		if(!authService.authenticate(authentication, user)){
			throw new BadCredentialsException("Basic Authentication Fail");
		}

		TokenResponse tokenResponse = authService.getTokenResponse(user);
		return Response.success(tokenResponse);
	}

	@PreAuthorize("hasRole('ROLE_REFRESH')")
	@PostMapping("/auth/refresh")
	public ResponseEntity<TokenResponse> refresh(){
		Authentication authentication = getCurrentAuthentication();
		String email = (String) authentication.getPrincipal();

		User user = this.userService.getUserByEmail(email);
		if(user == null){
			throw new UsernameNotFoundException(email);
		}

		TokenResponse tokenResponse = authService.getTokenResponse(user);
		return Response.success(tokenResponse);
	}

	private Authentication getCurrentAuthentication(){
		return SecurityContextHolder.getContext().getAuthentication();
	}
}
