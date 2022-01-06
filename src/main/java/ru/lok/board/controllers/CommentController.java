package ru.lok.board.controllers;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lok.board.DTO.CommentDTO;
import ru.lok.board.entity.Comment;
import ru.lok.board.entity.Task;
import ru.lok.board.repository.CommentRepository;
import ru.lok.board.service.CommentService;

import java.util.*;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private CommentRepository commentRepository;
    private CommentService commentService;

    public CommentController(CommentRepository commentRepository, CommentService commentService) {
        this.commentRepository = commentRepository;
        this.commentService = commentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> CommentById(@PathVariable String id) {
        return ResponseEntity.ok(commentService.commentById(Long.parseLong(id)));
    }

    @PostMapping("/add")
    public ResponseEntity<CommentDTO> add(@RequestBody CommentDTO commentDTO){

        return ResponseEntity.ok(commentService.addComment(commentDTO));
    }


    @GetMapping("/task/{id}")
    public ResponseEntity<List<Comment> > CommentsByTask(@PathVariable String id) {
        List<Comment> comments = new ArrayList<>();
        return ResponseEntity.ok(comments);
    }
}
