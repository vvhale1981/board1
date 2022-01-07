package ru.lok.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lok.board.dto.UserDto;
import ru.lok.board.dto.UserObjToDto;
import ru.lok.board.entity.User;
import ru.lok.board.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserObjToDto userObjToDto;

    public List<User> findAll() {

        return  userRepository.findAll();

    }

    public UserDto add(UserDto userDTO){
        User user =new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());

         User us = userRepository.save(user);
        return userObjToDto.userToUserDto(us);

    }

}
