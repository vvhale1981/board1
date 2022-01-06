package ru.lok.board.DTO;

import org.springframework.stereotype.Component;
import ru.lok.board.entity.User;

@Component
public class UserObjToDto {

    public UserDTO UserToUserDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setCreatedDate(user.getCreatedDate());
        return userDTO;

    }
}
