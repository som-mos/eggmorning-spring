package com.backend.sommos.service.inf;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface LoginService extends UserDetailsService{

    boolean login(String id, String password);

}
