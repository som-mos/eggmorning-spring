package com.backend.sommos.domain.user.service.inf;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.backend.sommos.domain.user.entity.User;

public interface UserService{
    void createUser(User user);
    User getUserByName(String username);
    User getUserByEmail(String username);
}
