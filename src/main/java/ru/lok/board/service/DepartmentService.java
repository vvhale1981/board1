package ru.lok.board.service;

import org.springframework.stereotype.Service;
import ru.lok.board.DTO.DepartmentDTO;
import ru.lok.board.entity.Department;
import ru.lok.board.entity.Task;
import ru.lok.board.repository.DepartmentRepository;
import ru.lok.board.repository.TaskRepository;

import java.util.List;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private TaskRepository taskRepository;

    public DepartmentService(DepartmentRepository departmentRepository, TaskRepository taskRepository) {
        this.departmentRepository = departmentRepository;
        this.taskRepository = taskRepository;
    }

    public Department createDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setTitle(departmentDTO.getTitle());
        department.setNameDepartment(departmentDTO.getNameDepartment());
        return departmentRepository.save(department);
    }


    public List<Task> getAllTaskForDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).get();
        return taskRepository.findTaskByDepartment(department).get();

    }


    public List<Task> getTaskForDepatment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).get();
        return taskRepository.findTaskByDepartment(department).get();

    }


}
