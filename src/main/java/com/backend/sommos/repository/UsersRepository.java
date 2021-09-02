package com.backend.sommos.repository;

import com.backend.sommos.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}


