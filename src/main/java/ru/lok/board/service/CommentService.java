package ru.lok.board.service;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import ru.lok.board.dto.CommentDto;
import ru.lok.board.entity.Comment;
import ru.lok.board.repository.CommentRepository;
import ru.lok.board.repository.TaskRepository;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;

    public CommentDto commentById(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NoSuchElementException("нет такого комментария"));
        return CommentDto.commentToDto(comment);
    }

    public CommentDto addComment(@NotNull CommentDto commentDTO) {
        Comment comment = new Comment();
        comment.setMessage(commentDTO.getMessage());
        comment.setUsername(commentDTO.getUsername());
        comment.setTask(taskRepository.findById(commentDTO.getTaskId()).get());
        comment = commentRepository.save(comment);
        return CommentDto.commentToDto(comment);


    }
}
