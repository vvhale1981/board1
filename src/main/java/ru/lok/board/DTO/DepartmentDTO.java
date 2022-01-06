package ru.lok.board.DTO;

import lombok.Data;

@Data
public class DepartmentDTO {

    private Long id;
    private String nameDepartment;
    private String title;

    public DepartmentDTO(Long id, String nameDepartment, String title) {
        this.id = id;
        this.nameDepartment = nameDepartment;
        this.title = title;
    }
}
