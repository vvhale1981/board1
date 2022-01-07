package ru.lok.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lok.board.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {


}
