package com.backend.sommos.domain.user.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backend.sommos.domain.user.repository.UsersRepository;
import com.backend.sommos.domain.user.service.inf.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    private UsersRepository usersRepository;
    @Override
    public boolean login(String id, String password) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
