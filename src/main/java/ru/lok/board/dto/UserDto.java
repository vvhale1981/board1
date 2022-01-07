package ru.lok.board.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.lok.board.entity.User;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private LocalDateTime createdDate;

    public static UserDto userToDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                "password",
                user.getCreatedDate());
    }
}
