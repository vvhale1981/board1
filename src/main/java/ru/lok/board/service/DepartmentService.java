package ru.lok.board.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lok.board.dto.DepartmentDto;
import ru.lok.board.entity.Department;
import ru.lok.board.entity.Task;
import ru.lok.board.repository.DepartmentRepository;
import ru.lok.board.repository.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final TaskRepository taskRepository;



    public Department createDepartment(DepartmentDto departmentDTO) {
        Department department = new Department();
        department.setTitle(departmentDTO.getTitle());
        department.setNameDepartment(departmentDTO.getNameDepartment());
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long departmentId){
        departmentRepository.delete(departmentRepository.findDepartmentById(departmentId).get());
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
