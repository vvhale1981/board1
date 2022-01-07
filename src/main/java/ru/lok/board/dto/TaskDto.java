package ru.lok.board.dto;

import lombok.*;
import ru.lok.board.entity.Task;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskDto {

    private Long id;
    private Long userId;
    private Long departmentId;
    private String title;
    private String message;
    private Integer complited;
    private LocalDateTime createdDate;


    public static TaskDto taskToDto(Task task){
        return new TaskDto(task.getId(),
                task.getUser().getId(),
                task.getDepartment().getId(),
                task.getTitle(),
                task.getMessage(),
                task.getComplited(),
                task.getCreatedDate()
        );
    }
}
