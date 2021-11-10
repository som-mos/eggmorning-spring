package com.backend.sommos.domain.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.sommos.domain.user.entity.User;
import com.backend.sommos.domain.user.repository.UsersRepository;
import com.backend.sommos.domain.user.service.inf.SignUpService;

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
