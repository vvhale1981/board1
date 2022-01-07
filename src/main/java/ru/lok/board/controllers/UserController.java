package ru.lok.board.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lok.board.dto.UserDto;
import ru.lok.board.entity.User;
import ru.lok.board.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public List<User> all() {
        return userService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<UserDto> add(@RequestBody UserDto userDTO) {
        return ResponseEntity.ok(userService.add(userDTO));
    }

    @PostMapping("/findbyusername")
    public ResponseEntity<UserDto> findUserByUsername(UserDto userDTO) {
        return null;
    }
}
