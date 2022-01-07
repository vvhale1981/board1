package ru.lok.board.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lok.board.dto.UserDto;
import ru.lok.board.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> all() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> add(@RequestBody UserDto userDTO) {
        return ResponseEntity.ok(userService.add(userDTO));
    }

    @PutMapping("/")
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDTO) {
        return ResponseEntity.ok(userService.update(userDTO));
    }

    @GetMapping("/serch/{username}")
    public ResponseEntity<UserDto> findUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.findUserByUsername(username));
    }
}
