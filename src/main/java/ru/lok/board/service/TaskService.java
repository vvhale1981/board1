package ru.lok.board.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lok.board.dto.TaskDto;
import ru.lok.board.entity.Comment;
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

    public TaskDto setComplit(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new NoSuchElementException("нет такой задачи"));
        task.setComplited(1);
        task = taskRepository.save(task);
        return TaskDto.taskToDto(task);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public TaskDto add(TaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setDepartment(departmentRepository.findById(taskDto.getDepartmentId())
                .orElseThrow(() -> new NoSuchElementException("нет такого департамента")));
        task.setList(new ArrayList<Comment>());
        task.setTitle(taskDto.getTitle());
        task.setMessage(taskDto.getMessage());
        task.setUser(userRepository.findById(taskDto.getUserId())
                .orElseThrow(() -> new NoSuchElementException("нет такого пользователя")));
        task.setComplited(0);
        return TaskDto.taskToDto(taskRepository.save(task));
    }

}
