package com.backend.sommos.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backend.sommos.entities.User;
import com.backend.sommos.entities.SomUserDetails;

@Service("somUserDetailsService")
public class SomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        SomUserDetails userDetails = null;
        if( user != null){
            userDetails = new SomUserDetails();
            userDetails.setUsername(user.getUsername());
            userDetails.setPassword(user.getPassword());
        }

        return userDetails;
    }
}
