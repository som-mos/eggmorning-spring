package com.backend.eggmorning.domain.user.service.inf;

import com.backend.eggmorning.domain.user.entity.User;

public interface UserService{
    void createUser(User user);
    User getUserByName(String username);
    User getUserByEmail(String username);
}
