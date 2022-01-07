package ru.lok.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.lok.board.entity.Department;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentDto {

    private Long id;
    private String nameDepartment;
    private String title;

    public static DepartmentDto departmentToDto(Department department){
        return new DepartmentDto(
                department.getId(),
                department.getNameDepartment(),
                department.getTitle()
        );
    }


}
