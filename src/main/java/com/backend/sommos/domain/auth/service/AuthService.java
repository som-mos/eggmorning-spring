package com.backend.sommos.domain.auth.service;

import com.backend.sommos.domain.auth.dto.BasicAuthentication;
import com.backend.sommos.domain.auth.dto.TokenResponse;
import com.backend.sommos.domain.user.service.inf.UserService;
import com.backend.sommos.global.security.service.inf.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.sommos.domain.user.entity.User;

@Service
public class AuthService {
	private JwtService jwtService;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public AuthService(JwtService jwtService, PasswordEncoder passwordEncoder) {
		this.jwtService = jwtService;
		this.passwordEncoder = passwordEncoder;
	}

	public boolean authenticate(BasicAuthentication authentication, User user){
		String rawPassword = user.getSalt() + authentication.password;
		String encodedPassword = user.getPassword();
		return this.passwordEncoder.matches(rawPassword, encodedPassword);
	};

	public TokenResponse getTokenResponse(User user){
		String jwtToken = this.jwtService.createToken(user);
		String refreshToken = this.jwtService.createRefreshToken(user);

		return TokenResponse.builder()
				.jwtToken(jwtToken)
				.refreshToken(refreshToken)
				.build();
	};
}
