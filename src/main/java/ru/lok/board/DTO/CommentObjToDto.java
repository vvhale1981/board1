package ru.lok.board.DTO;

import org.springframework.stereotype.Component;
import ru.lok.board.entity.Comment;

@Component
public class CommentObjToDto {
    public CommentDTO commentToCommentDTO(Comment comment){
        CommentDTO commentDTO = new CommentDTO(
                comment.getId(),
                comment.getTask().getId(),
                comment.getUsername(),
                comment.getMessage(),
                comment.getCreatedDate()
        );
        return commentDTO;
    }

}
