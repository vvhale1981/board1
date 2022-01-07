package ru.lok.board.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.lok.board.entity.User;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto extends DateCreateUpdateDto {
    private Long id;
    private String username;
    private String password;


    public static UserDto userToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword("password");
        userDto.setCreatedDate(user.getCreatedDate());
        userDto.setUpdatedDate(user.getUpdateDate());
        return userDto;
    }
}
