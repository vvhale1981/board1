package ru.lok.board.service;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.lok.board.dto.CommentDto;
import ru.lok.board.entity.Comment;
import ru.lok.board.repository.CommentRepository;
import ru.lok.board.repository.TaskRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;

    public CommentDto commentById(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NoSuchElementException("not found comment with id " + commentId));
        return CommentDto.commentToDto(comment);
    }

    public CommentDto addComment(@NotNull CommentDto commentDTO) {
        Comment comment = new Comment();
        comment.setMessage(commentDTO.getMessage());
        comment.setUsername(commentDTO.getUsername());
        comment.setTask(taskRepository.findById(commentDTO.getTaskId())
                .orElseThrow(() -> new NoSuchElementException("not found task with id" + commentDTO.getTaskId())));//дописать исключение
        comment = commentRepository.save(comment);
        return CommentDto.commentToDto(comment);
    }

    public void deletComment(Long commentId) {
        commentRepository.findById(commentId).orElseThrow(() -> new NoSuchElementException("not found comment to delete"));
        commentRepository.deleteById(commentId);
    }

    public List<CommentDto> CommentsByTask(Long taskId, PageRequest pageRequest) {
        return commentRepository.findAllByTask(taskRepository.findById(taskId)
                        .orElseThrow(() -> new NoSuchElementException("not found task with id" + taskId)), pageRequest)
                .stream().map(CommentDto::commentToDto).collect(Collectors.toList());
    }
}
