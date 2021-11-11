package com.backend.sommos.domain.user.mapper;

import com.backend.sommos.domain.user.dto.UserDTO;
import com.backend.sommos.domain.user.entity.User;

public class UserMapper {
    public User convertToUser(UserDTO userDto){
        User user = new User();
        user.setUsername(userDto.username);
        user.setPassword(userDto.password);

        return user;
    }

    public UserDTO convertToUserDTO(User user){
        UserDTO userDto = new UserDTO();
        userDto.username = user.getUsername();
        userDto.password = user.getPassword();

        return userDto;
    }
}
