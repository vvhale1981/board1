package ru.lok.board.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @GetMapping("/{page}/{pageSize}")
    public ResponseEntity<List<UserDto>> all(@PathVariable int page,
                                             @PathVariable int pageSize) {

        Sort sort = Sort.by(Sort.Direction.DESC, "createdDate");
        PageRequest pageRequest = PageRequest.of(page, pageSize, sort);
        return ResponseEntity.ok(userService.findAll(pageRequest));
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
