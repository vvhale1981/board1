package ru.lok.board.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.lok.board.dto.UserDto;
import ru.lok.board.entity.User;
import ru.lok.board.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDto> findAll(PageRequest pageRequest) {
        return userRepository.findAll(pageRequest).stream().map(UserDto::userToDto).collect(Collectors.toList());
    }

    public UserDto add(UserDto userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        User us = userRepository.save(user);
        return UserDto.userToDto(us);
    }

    public UserDto findUserByUsername(String username) {
        return UserDto.userToDto(userRepository.findUserByUsername(username)
                .orElseThrow(() -> new NoSuchElementException("not found user with username " + username)));
    }

    public UserDto update(UserDto userDTO) {
        User user;
        user = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new NoSuchElementException("not found user with id " + userDTO.getId()));
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user = userRepository.save(user);
        return UserDto.userToDto(user);
    }
}
