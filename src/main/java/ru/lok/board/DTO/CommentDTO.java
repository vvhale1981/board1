package ru.lok.board.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;


@Data
public class CommentDTO {
    private Long id;
    private Long taskId;
    private String username;
    private String message;
    private LocalDateTime createdDate;

    public CommentDTO(Long id, Long taskId, String username, String message) {
        this.id = id;
        this.taskId = taskId;
        this.username = username;
        this.message = message;
    }
}
