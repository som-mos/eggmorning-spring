package com.backend.eggmorning.global.security.provider;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.backend.eggmorning.domain.user.entity.User;
import com.backend.eggmorning.domain.user.repository.UserRepository;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

	private UserRepository usersRepository;

	public UserAuthenticationProvider(UserRepository usersRepository){
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
