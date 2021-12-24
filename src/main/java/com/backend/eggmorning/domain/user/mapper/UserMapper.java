package com.backend.eggmorning.domain.user.mapper;

import com.backend.eggmorning.domain.user.dto.UserDTO;
import com.backend.eggmorning.domain.user.entity.User;

public class UserMapper {
    public User convertToUser(UserDTO userDto){
        User user = new User();
        user.setName(userDto.username);
        user.setPassword(userDto.password);

        return user;
    }

    public UserDTO convertToUserDTO(User user){
        UserDTO userDto = new UserDTO();
        userDto.username = user.getName();
        userDto.password = user.getPassword();

        return userDto;
    }
}
