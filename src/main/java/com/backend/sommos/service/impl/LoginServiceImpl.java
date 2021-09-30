package com.backend.sommos.service.impl;

import com.backend.sommos.entities.User;
import com.backend.sommos.repository.UsersRepository;
import com.backend.sommos.service.inf.LoginService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
