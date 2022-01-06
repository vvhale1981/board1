package ru.lok.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lok.board.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
