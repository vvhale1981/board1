package ru.lok.board.service;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import ru.lok.board.dto.CommentDto;
import ru.lok.board.dto.CommentObjToDto;
import ru.lok.board.entity.Comment;
import ru.lok.board.repository.CommentRepository;
import ru.lok.board.repository.TaskRepository;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;
    private final CommentObjToDto commentObjToDto;

   // public CommentService(CommentRepository commentRepository, TaskRepository taskRepository, CommentObjToDto commentObjToDto) {
   //     this.commentRepository = commentRepository;
   //     this.taskRepository = taskRepository;
   //     this.commentObjToDto = commentObjToDto;
   // }

    public String commentById(Long commentId) {
        return commentRepository.findById(commentId).get().getMessage();
    }

    public CommentDto addComment(@NotNull CommentDto commentDTO) {
        Comment comment = new Comment();
        comment.setMessage(commentDTO.getMessage());
        comment.setUsername(commentDTO.getUsername());
        comment.setTask(taskRepository.findById(commentDTO.getTaskId()).get());
        comment = commentRepository.save(comment);
        //commentDTO.setId(comment.getId());
        //commentDTO.setCreatedDate(comment.getCreatedDate());

        return commentObjToDto.commentToCommentDTO(comment);


    }
}
