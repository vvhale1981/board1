package ru.lok.board.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.lok.board.entity.User;
import ru.lok.board.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {

        this.userRepository = userRepository;

    }

    @GetMapping("/all")
    public List<User> test() {
        List<User> list = userRepository.findAll();
        return list;

    }

    @PostMapping("/add")
    public  void add(@RequestBody User user){
        userRepository.save(user);

    }
}
