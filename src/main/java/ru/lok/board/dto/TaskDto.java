package ru.lok.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.lok.board.entity.Task;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskDto extends DateCreateUpdateDto {

    private Long id;
    private Long userId;
    private Long departmentId;
    private String title;
    private String message;
    private Integer complited;


    public static TaskDto taskToDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setUserId(task.getDepartment().getId());
        taskDto.setDepartmentId(task.getDepartment().getId());
        taskDto.setTitle(task.getTitle());
        taskDto.setMessage(task.getMessage());
        taskDto.setComplited(task.getComplited());
        taskDto.setCreatedDate(task.getCreatedDate());
        taskDto.setUpdatedDate(task.getUpdateDate());
        return taskDto;

    }
}
