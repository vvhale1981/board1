package ru.lok.board.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.lok.board.dto.TaskDto;
import ru.lok.board.entity.Task;
import ru.lok.board.repository.DepartmentRepository;
import ru.lok.board.repository.TaskRepository;
import ru.lok.board.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final DepartmentRepository departmentRepository;
    private final UserRepository userRepository;

    public TaskDto setComplit(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new NoSuchElementException("not found task with id " + taskId));
        task.setComplited(1);
        task = taskRepository.save(task);
        return TaskDto.taskToDto(task);
    }

    public Page<Task> findAll(PageRequest pageRequest) {
        return taskRepository.findAll(pageRequest);
    }

    public TaskDto add(TaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setDepartment(departmentRepository.findById(taskDto.getDepartmentId())
                .orElseThrow(() -> new NoSuchElementException("not found department with id " + taskDto.getDepartmentId())));
        task.setList(new ArrayList<>());
        task.setTitle(taskDto.getTitle());
        task.setMessage(taskDto.getMessage());
        task.setUser(userRepository.findById(taskDto.getUserId())
                .orElseThrow(() -> new NoSuchElementException("not found user with id " + taskDto.getUserId())));
        task.setComplited(0);
        return TaskDto.taskToDto(taskRepository.save(task));
    }

}
