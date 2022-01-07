package ru.lok.board.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lok.board.dto.TaskDto;
import ru.lok.board.service.TaskService;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/all")
    public ResponseEntity<List<TaskDto>> findAll() {
        List<TaskDto> taskDto = taskService.findAll().stream().map(TaskDto::taskToDto).collect(Collectors.toList());
        return ResponseEntity.ok(taskDto);
    }

    @PostMapping("/add")
    public ResponseEntity<TaskDto> addTask(@RequestBody TaskDto taskDTO) {

        return ResponseEntity.ok(taskService.add(taskDTO));
    }

    @PostMapping("/update")
    public ResponseEntity<TaskDto> update(@RequestBody TaskDto taskDTO) {
        return ResponseEntity.ok(taskService.add(taskDTO));
    }

    @GetMapping("/{id}/setcomplit")
    public ResponseEntity<TaskDto> setComplit(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.setComplit(id));


    }
}
