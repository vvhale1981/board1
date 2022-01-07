package ru.lok.board.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lok.board.dto.TaskDto;
import ru.lok.board.entity.Task;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskController {

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
}
