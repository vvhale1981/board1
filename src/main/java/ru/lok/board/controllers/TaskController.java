package ru.lok.board.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @GetMapping("/{page}/{pageSize}")//paging
    public ResponseEntity<List<TaskDto>> findAll(@PathVariable int page,
                                                 @PathVariable int pageSize) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdDate");
        PageRequest pageRequest = PageRequest.of(page, pageSize, sort);
        List<TaskDto> taskDto = taskService.findAll(pageRequest).stream().map(TaskDto::taskToDto).collect(Collectors.toList());
        return ResponseEntity.ok(taskDto);
    }

    @PostMapping("/")
    public ResponseEntity<TaskDto> addTask(@RequestBody TaskDto taskDTO) {
        return ResponseEntity.ok(taskService.add(taskDTO));
    }

    @PutMapping("/")
    public ResponseEntity<TaskDto> update(@RequestBody TaskDto taskDTO) {
        return ResponseEntity.ok(taskService.add(taskDTO));
    }

    @GetMapping("/{id}/setcomplit")
    public ResponseEntity<TaskDto> setComplit(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.setComplit(id));


    }
}
