package com.backend.eggmorning.domain.auth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.eggmorning.domain.auth.dto.BasicAuthentication;
import com.backend.eggmorning.domain.auth.dto.TokenResponse;
import com.backend.eggmorning.domain.user.entity.User;
import com.backend.eggmorning.global.security.service.JwtService;

@Service
public class AuthService {
	private JwtService jwtService;
	private PasswordEncoder passwordEncoder;

	public AuthService(JwtService jwtService, PasswordEncoder passwordEncoder) {
		this.jwtService = jwtService;
		this.passwordEncoder = passwordEncoder;
	}

	public boolean authenticate(BasicAuthentication authentication, User user) {
		String rawPassword = user.getSalt() + authentication.password;
		String encodedPassword = user.getPassword();
		return this.passwordEncoder.matches(rawPassword, encodedPassword);
	}

	;

	public TokenResponse getTokenResponse(User user) {
		String jwtToken = this.jwtService.createToken(user);
		String refreshToken = this.jwtService.createRefreshToken(user);

		return TokenResponse.builder()
			.jwtToken(jwtToken)
			.refreshToken(refreshToken)
			.build();
	}

	;
}
