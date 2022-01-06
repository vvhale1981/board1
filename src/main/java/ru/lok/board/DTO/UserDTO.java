package ru.lok.board.DTO;


import lombok.Data;


import java.time.LocalDateTime;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private LocalDateTime createdDate;

}
