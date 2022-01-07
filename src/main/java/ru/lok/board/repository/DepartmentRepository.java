package ru.lok.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lok.board.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
