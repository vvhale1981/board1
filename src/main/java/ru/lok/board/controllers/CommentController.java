package ru.lok.board.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lok.board.dto.CommentDto;
import ru.lok.board.entity.Comment;
import ru.lok.board.service.CommentService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;


    @GetMapping("/{id}")
    public ResponseEntity<String> CommentById(@PathVariable String id) {
        return ResponseEntity.ok(commentService.commentById(Long.parseLong(id)));
    }

    @PostMapping("/add")
    public ResponseEntity<CommentDto> add(@RequestBody CommentDto commentDTO) {
        CommentDto com = commentService.addComment(commentDTO);
        return ResponseEntity.ok(com);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity deleteComment(@PathVariable Long id) {
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<List<Comment>> CommentsByTask(@PathVariable String id) {
        List<Comment> comments = new ArrayList<>();
        return ResponseEntity.ok(comments);
    }
}
