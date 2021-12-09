package com.backend.sommos.global.config.security.provider;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.backend.sommos.domain.user.entity.User;
import com.backend.sommos.domain.user.repository.UsersRepository;

@Component
public class SomAuthenticationProvider implements AuthenticationProvider {

	private UsersRepository usersRepository;

	@Autowired
	public SomAuthenticationProvider(UsersRepository usersRepository){
		super();
		this.usersRepository = usersRepository;
	}
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = (String) authentication.getPrincipal();
		String givenPassword = (String) authentication.getCredentials();

		User user = this.usersRepository.findByName(username);
		if(user == null){
			throw new BadCredentialsException(username);
		}

		String userPassword = user.getPassword();
		if(userPassword == null || !userPassword.equals(givenPassword)){
			throw new BadCredentialsException(username);
		}

		return new UsernamePasswordAuthenticationToken(username, givenPassword, new ArrayList<>());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
