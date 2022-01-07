package ru.lok.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lok.board.entity.Department;
import ru.lok.board.entity.Task;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<List<Task>> findTaskByDepartment(Department department);
}
