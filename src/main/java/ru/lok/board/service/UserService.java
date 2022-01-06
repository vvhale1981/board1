package ru.lok.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lok.board.DTO.UserDTO;
import ru.lok.board.DTO.UserObjToDto;
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

    public UserDTO add(UserDTO userDTO){
        User user =new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());

         User us = userRepository.save(user);
        return userObjToDto.UserToUserDto(us);

    }

}
