package ru.lok.board.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lok.board.dto.TaskDto;
import ru.lok.board.entity.Task;
import ru.lok.board.repository.TaskRepository;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskDto setComplit(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new NoSuchElementException("нет такой задачи"));
        task.setComplited(1);
        task = taskRepository.save(task);
        return TaskDto.taskToDto(task);
    }
}
