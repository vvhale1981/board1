package ru.lok.board.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lok.board.dto.CommentDto;
import ru.lok.board.service.CommentService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;


    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> сommentById(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.commentById(id));
    }

    @PostMapping("/")
    public ResponseEntity<CommentDto> add(@RequestBody CommentDto commentDTO) {
        CommentDto com = commentService.addComment(commentDTO);
        return ResponseEntity.ok(com);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long id) {
        commentService.deletComment(id);
        return ResponseEntity.ok(" deleted comment id " + id);
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<List<CommentDto>> CommentsByTask(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.CommentsByTask(id));

    }
}
