package com.backend.eggmorning.domain.auth.controller;

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

import com.backend.eggmorning.domain.auth.dto.BasicAuthentication;
import com.backend.eggmorning.domain.auth.dto.TokenResponse;
import com.backend.eggmorning.domain.auth.service.AuthService;
import com.backend.eggmorning.domain.user.entity.User;
import com.backend.eggmorning.domain.user.service.inf.UserService;
import com.backend.eggmorning.global.network.Response;
import com.backend.eggmorning.global.security.annotation.Public;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SocialAuthController {
	private AuthService authService;
	private UserService userService;

	public SocialAuthController(AuthService authService, UserService userService){
		this.authService = authService;
		this.userService = userService;
	}

	@Public
	@PostMapping("/auth/kakao")
	public ResponseEntity<TokenResponse> login(@RequestBody String soc){
		return Response.success(TokenResponse.builder().build());
	}
}
