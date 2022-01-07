package ru.lok.board.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lok.board.dto.TaskDto;
import ru.lok.board.entity.Task;
import ru.lok.board.service.TaskService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/all")
    public ResponseEntity<List<Task>> findAll() {
        return null;
    }

    @PostMapping("/add")
    public ResponseEntity<TaskDto> addTask(TaskDto taskDTO) {
        return ResponseEntity.ok(taskDTO);
    }

    @PostMapping("/update")
    public ResponseEntity<TaskDto> update(TaskDto taskDTO) {
        return null;
    }

    @GetMapping("/{id}/setcomlit")
    public  ResponseEntity<TaskDto> setComplit(@PathVariable Long id){
        return ResponseEntity.ok(taskService.setComplit(id));



    }
}
