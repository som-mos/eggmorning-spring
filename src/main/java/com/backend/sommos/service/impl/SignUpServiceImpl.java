package com.backend.sommos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backend.sommos.entities.User;
import com.backend.sommos.repository.UsersRepository;
import com.backend.sommos.service.inf.LoginService;
import com.backend.sommos.service.inf.SignUpService;

@Service("signUpService")
public class SignUpServiceImpl implements SignUpService {

    private UsersRepository usersRepository;

    @Autowired
    public SignUpServiceImpl(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public boolean signUp(User user) {
        try {
            this.usersRepository.save(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
