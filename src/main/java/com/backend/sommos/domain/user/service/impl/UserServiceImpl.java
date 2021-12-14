package com.backend.sommos.domain.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backend.sommos.domain.user.entity.User;
import com.backend.sommos.domain.user.repository.UserRepository;
import com.backend.sommos.domain.user.service.inf.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserRepository usersRepository;

    @Autowired
    public UserServiceImpl(UserRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public void createUser(User user) {
        this.usersRepository.save(user);
    }

    public User getUserByName(String username) throws UsernameNotFoundException {
        return this.usersRepository.findByName(username);
    }

    @Override
    public User getUserByEmail(String email) {
        return this.usersRepository.findByEmail(email);
    }
}
