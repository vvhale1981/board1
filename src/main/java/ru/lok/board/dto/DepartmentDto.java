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
public class DepartmentDto extends DateCreateUpdateDto {

    private Long id;
    private String nameDepartment;
    private String title;

    public static DepartmentDto departmentToDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setNameDepartment(department.getNameDepartment());
        departmentDto.setTitle(department.getTitle());
        departmentDto.setCreatedDate(department.getCreatedDate());
        departmentDto.setUpdatedDate(department.getUpdateDate());
        return departmentDto;
    }


}
