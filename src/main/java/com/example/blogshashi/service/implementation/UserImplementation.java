package com.example.blogshashi.service.implementation;

import com.example.blogshashi.entities.User;
import com.example.blogshashi.exceptions.ApiException;
import com.example.blogshashi.exceptions.ResourceNotFoundException;
import com.example.blogshashi.payloads.UserDto;
import com.example.blogshashi.repositories.UserRepository;
import com.example.blogshashi.service.UserService;
import org.modelmapper.Converters;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserImplementation  implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User  user = dtoToUser(userDto);
       try{
           User save = this.userRepository.save(user);
           return userToDto(save);
       }catch (Exception e){
           throw new ApiException("error hai bhai error hai");
       }

    }

    @Override
    public UserDto updateUser(UserDto userDto,Integer id) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id ", id));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        User save = this.userRepository.save(user);
       return  userToDto(save);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
        UserDto userDto = userToDto(user);
        return  userDto;


    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return  userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
        this.userRepository.deleteById(userId);

    }


    //converting
    public User dtoToUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);

        // user.setId(userDto.getId());
        // user.setName(userDto.getName());
        // user.setEmail(userDto.getEmail());
        // user.setAbout(userDto.getAbout());
        // user.setPassword(userDto.getPassword());
        return user;
    }
    public UserDto userToDto(User user) {
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
