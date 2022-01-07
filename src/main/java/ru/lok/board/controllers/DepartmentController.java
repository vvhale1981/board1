package ru.lok.board.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lok.board.dto.DepartmentDto;
import ru.lok.board.dto.TaskDto;
import ru.lok.board.entity.Department;
import ru.lok.board.repository.DepartmentRepository;
import ru.lok.board.service.DepartmentService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/department")
public class DepartmentController {


    private final DepartmentService departmentService;
    private final DepartmentRepository departmentRepository;


    @PostMapping("/")
    public ResponseEntity<Department> add(@RequestBody DepartmentDto departmentDto) {
        return ResponseEntity.ok(departmentService.createDepartment(departmentDto));
    }

    @GetMapping("/{idDep}/task")
    public ResponseEntity<List<TaskDto>> getTask(@PathVariable Long idDep) {
        Department department = departmentRepository.findById(idDep)
                .orElseThrow(() -> new NoSuchElementException("not found department with id " + idDep));
        List<TaskDto> taskDtos = departmentService.getTaskForDepatment(department.getId())
                .stream().map(TaskDto::taskToDto).collect(Collectors.toList());
        return ResponseEntity.ok(taskDtos);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("ok");
    }
}
