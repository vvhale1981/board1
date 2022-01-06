package ru.lok.board.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lok.board.DTO.TaskDTO;
import ru.lok.board.entity.Task;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @GetMapping("/all")
    public ResponseEntity<List<Task>> findAll(){
        return null;
    }

    @PostMapping("/add")
    public ResponseEntity<TaskDTO> addTask(TaskDTO taskDTO){

        return ResponseEntity.ok(taskDTO);
    }

    @PostMapping("/update")
    public ResponseEntity<TaskDTO> update(TaskDTO taskDTO){
        return null;
    }


}
