package ru.lok.board.dto;

import org.springframework.stereotype.Component;
import ru.lok.board.entity.User;

@Component
public class UserObjToDto {

    public UserDto userToUserDto(User user) {
        UserDto userDTO = new UserDto();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setCreatedDate(user.getCreatedDate());
        return userDTO;

    }
}
