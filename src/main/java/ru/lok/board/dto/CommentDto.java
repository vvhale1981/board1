package ru.lok.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.lok.board.entity.Comment;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CommentDto extends DateCreateUpdateDto {
    private Long id;
    private Long taskId;
    private String username;
    private String message;

    public static CommentDto commentToDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setTaskId(comment.getTask().getId());
        commentDto.setUsername(comment.getUsername());
        commentDto.setMessage(comment.getMessage());
        commentDto.setCreatedDate(comment.getCreatedDate());
        commentDto.setUpdatedDate(comment.getUpdateDate());
        return commentDto;
    }
}
