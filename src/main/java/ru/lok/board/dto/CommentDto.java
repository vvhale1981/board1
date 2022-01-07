package ru.lok.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.lok.board.entity.Comment;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CommentDto {
    private Long id;
    private Long taskId;
    private String username;
    private String message;
    private LocalDateTime createdDate;

    public static CommentDto commentToDto(Comment comment){
        return new CommentDto(
                comment.getId(),
                comment.getTask().getId(),
                comment.getUsername(),
                comment.getMessage(),
                comment.getCreatedDate()
        );
    }


}
