package ru.lok.board.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lok.board.dto.DepartmentDto;
import ru.lok.board.entity.Department;
import ru.lok.board.entity.Task;
import ru.lok.board.repository.DepartmentRepository;
import ru.lok.board.service.DepartmentService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/department")
public class DepartmentController {


    private final DepartmentService departmentService;
    private final DepartmentRepository departmentRepository;


    @PostMapping("/add")
    public ResponseEntity<Department> add(@RequestBody DepartmentDto departmentDTO) {
        return ResponseEntity.ok(departmentService.createDepartment(departmentDTO));
    }

    @PostMapping("/task")
    public ResponseEntity<List<Task>> getNotComlitedTask(@RequestBody DepartmentDto departmentDTO) {
        Long depId = departmentDTO.getId();
        Department department = departmentRepository.findDepartmentById(depId).get();
        return ResponseEntity.ok(departmentService.getTaskForDepatment(department.getId()));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("ok");
    }
}
