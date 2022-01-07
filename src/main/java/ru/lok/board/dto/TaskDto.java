package ru.lok.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@AllArgsConstructor
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
}
