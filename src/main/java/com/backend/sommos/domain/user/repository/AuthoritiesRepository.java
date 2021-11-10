package com.backend.sommos.domain.user.repository;

import com.backend.sommos.domain.user.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthoritiesRepository extends JpaRepository<Authority, Integer> {
    List<Authority> findByUsername(String username);
}
