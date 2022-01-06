package ru.lok.board.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lok.board.DTO.UserDTO;
import ru.lok.board.entity.User;
import ru.lok.board.repository.UserRepository;
import ru.lok.board.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> all() {
        return userService.findAll();

    }

    @PostMapping("/add")
    public ResponseEntity<UserDTO> add(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.add(userDTO));

    }

    @PostMapping("/findbyusername")
    public ResponseEntity<UserDTO> findUserByUsername(UserDTO userDTO) {
        return null;

    }
}
