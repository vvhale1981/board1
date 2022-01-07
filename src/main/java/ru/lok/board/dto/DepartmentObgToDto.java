package ru.lok.board.dto;

import org.springframework.stereotype.Component;
import ru.lok.board.entity.Department;

@Component
public class DepartmentObgToDto {
    public DepartmentDto departmentToDTO(Department department) {
        return new DepartmentDto(
                department.getId(),
                department.getNameDepartment(),
                department.getTitle()
        );
    }
}
