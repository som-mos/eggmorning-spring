package com.backend.sommos.repository;

import com.backend.sommos.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthoritiesRepository extends JpaRepository<Authority, Integer> {
    List<Authority> findByUsername(String username);
}
