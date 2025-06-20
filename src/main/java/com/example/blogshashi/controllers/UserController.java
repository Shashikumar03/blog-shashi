package com.example.blogshashi.controllers;

import com.example.blogshashi.payloads.ApiResponse;
import com.example.blogshashi.payloads.UserDto;
import com.example.blogshashi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;
    // create user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createUserDto = this.userService.createUser(userDto);
       return   new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }
    // update user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer id){
        UserDto updatedUserDto = userService.updateUser(userDto, id);
        return new ResponseEntity<>(updatedUserDto,HttpStatus.OK);
    }
    // delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUSer(@PathVariable("userId") Integer userId){
        this.userService.deleteUser(userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully", true), HttpStatus.OK);
    }
    // Get users
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getUsers(){
        List<UserDto> allUsers = this.userService.getAllUsers();
         return new ResponseEntity<>(allUsers,HttpStatus.OK);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUsers(@PathVariable("userId")Integer id){
        UserDto userById = this.userService.getUserById(id);
        return  new ResponseEntity<>(userById,HttpStatus.OK);
    }
}
