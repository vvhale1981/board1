package ru.lok.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lok.board.DTO.CommentDTO;
import ru.lok.board.entity.Comment;
import ru.lok.board.repository.CommentRepository;
import ru.lok.board.repository.TaskRepository;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private TaskRepository taskRepository;

    public CommentService(CommentRepository commentRepository, TaskRepository taskRepository) {
        this.commentRepository = commentRepository;
        this.taskRepository = taskRepository;
    }

    public String commentById(Long commentId){
        return commentRepository.findById(commentId).get().getMessage();
    }

    public CommentDTO addComment(CommentDTO commentDTO ){
        Comment comment = new Comment();
        comment.setMessage(commentDTO.getMessage());
        comment.setUsername(commentDTO.getUsername());
        comment.setTask(taskRepository.findById(commentDTO.getTaskId()).get());
        comment = commentRepository.save(comment);
        commentDTO.setId(comment.getId());
        commentDTO.setCreatedDate(comment.getCreatedDate());
        return commentDTO;


    }
}
