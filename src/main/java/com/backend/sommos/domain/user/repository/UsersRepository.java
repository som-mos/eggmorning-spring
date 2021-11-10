package com.backend.sommos.domain.user.repository;

import com.backend.sommos.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}


