package com.backend.eggmorning.domain.user.repository;

import com.backend.eggmorning.domain.user.entity.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByName(String name);
    User findByEmail(String email);
    User save(String email);
}


