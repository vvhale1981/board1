package ru.lok.board.DTO;

import lombok.Data;
import java.time.LocalDateTime;


@Data
public class TaskDTO {

    private Long id;
    private Long userId;
    private Long departmentId;
    private String title;
    private String message;
    private Integer complited;
    private LocalDateTime createdDate;
}
