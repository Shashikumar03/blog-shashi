package com.example.blogshashi.service;


import com.example.blogshashi.payloads.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto,Integer id);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
     void deleteUser(Integer id);

}
