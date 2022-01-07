package ru.lok.board.dto;

import org.springframework.stereotype.Component;
import ru.lok.board.entity.Comment;

@Component
public class CommentObjToDto {
    public CommentDto commentToCommentDTO(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getTask().getId(),
                comment.getUsername(),
                comment.getMessage(),
                comment.getCreatedDate()
        );
    }

}
