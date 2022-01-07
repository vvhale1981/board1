package ru.lok.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@AllArgsConstructor
@Setter
@Getter
public class CommentDto {
    private Long id;
    private Long taskId;
    private String username;
    private String message;
    private LocalDateTime createdDate;


}
