package ru.lok.board.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lok.board.DTO.DepartmentDTO;
import ru.lok.board.entity.Department;
import ru.lok.board.entity.Task;
import ru.lok.board.repository.DepartmentRepository;
import ru.lok.board.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping("/add")
    public ResponseEntity<Department> add(@RequestBody DepartmentDTO departmentDTO) {
        return ResponseEntity.ok(departmentService.createDepartment(departmentDTO));

    }

    @PostMapping("/task")
    public ResponseEntity<List<Task>> getNotComlitedTask(@RequestBody DepartmentDTO departmentDTO){
        Long depId = departmentDTO.getId();
        Department department = departmentRepository.findDepartmentById(depId).get();

        return ResponseEntity.ok(departmentService.getTaskForDepatment(department.getId()));

    }


}
