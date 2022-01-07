package ru.lok.board.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lok.board.dto.TaskDto;
import ru.lok.board.dto.UserDto;
import ru.lok.board.entity.User;
import ru.lok.board.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {


    private final UserRepository userRepository;



    public List<User> findAll() {

        return  userRepository.findAll();

    }

    public UserDto add(UserDto userDTO){
        User user =new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());

         User us = userRepository.save(user);
        return UserDto.userToDto(us);

    }

}
