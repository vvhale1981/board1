package ru.lok.board.controllers;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lok.board.dto.DepartmentDto;
import ru.lok.board.dto.TaskDto;
import ru.lok.board.entity.Department;
import ru.lok.board.service.DepartmentService;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/department")
public class DepartmentController {


    private final DepartmentService departmentService;


    @PostMapping("/")
    public ResponseEntity<Department> add(@RequestBody DepartmentDto departmentDto) {
        return ResponseEntity.ok(departmentService.createDepartment(departmentDto));
    }

    @GetMapping("/{idDep}/task/{page}/{pageSize}")
    public ResponseEntity<List<TaskDto>> getTask(@PathVariable Long idDep,
                                                 @PathVariable int page,
                                                 @PathVariable int pageSize) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdDate");
        PageRequest pageRequest = PageRequest.of(page, pageSize, sort);
        List<TaskDto> taskDtos = departmentService.getTaskForDepatment(idDep, pageRequest)
                .stream().map(TaskDto::taskToDto).collect(Collectors.toList());
        return ResponseEntity.ok(taskDtos);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("ok");
    }
}
