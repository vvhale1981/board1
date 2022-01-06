package ru.lok.board.DTO;

import org.springframework.stereotype.Component;
import ru.lok.board.entity.Department;

@Component
public class DepartmentObgToDto {
    public DepartmentDTO departmentToDTO(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTO(
                department.getId(),
                department.getNameDepartment(),
                department.getTitle()
        );
        return departmentDTO;
    }
}
