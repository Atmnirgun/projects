package com.ifast.controller;

import com.ifast.dto.UserDto;
import com.ifast.entities.User;
import com.ifast.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/user/{id}")
    public ResponseEntity getUser(@PathVariable(name = "id") int id){
        ModelMapper modelMapper = new ModelMapper();
        User savedUser = userService.getUser(id);
        UserDto userDto = modelMapper.map(savedUser,UserDto.class);
        System.out.println(userDto);
        return new ResponseEntity(userDto,HttpStatus.OK);
    }

    @PostMapping(value = "/api/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveUser(@RequestBody UserDto userDto){
        ModelMapper modelMapper = new ModelMapper();
        User newUser = modelMapper.map(userDto,User.class);
        User savedUser = userService.createUser(newUser);
        UserDto savedUserDto = modelMapper.map(savedUser,UserDto.class);
        return new ResponseEntity(savedUserDto,HttpStatus.CREATED);
    }

    @DeleteMapping("/api/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable(name="id") int id){
        Boolean deleteStatus = userService.deleteUser(id);
        if(deleteStatus == true){
            return new ResponseEntity("User deleted successfully",HttpStatus.OK);
        }
        return new ResponseEntity("No user foound",HttpStatus.OK);
    }

    @PutMapping("/api/update/{id}")
    public ResponseEntity updateUser(@PathVariable(name = "id") int id,@RequestBody UserDto userDto){
        User savedUser = userService.getUser(id);
        savedUser.setFirstName(userDto.getFirstName());
        savedUser.setLastName(userDto.getLastName());
        User updatedUser = userService.createUser(savedUser);
        ModelMapper modelMapper = new ModelMapper();
        UserDto updatedUserDto = modelMapper.map(updatedUser,UserDto.class);
        return new ResponseEntity(updatedUserDto,HttpStatus.CREATED);
    }

    @GetMapping("/api/users")
    public ResponseEntity getAllUser(){
        List<User> userList = userService.getAllUser();
        List<UserDto> userDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for(User user:userList){
           UserDto userDto = modelMapper.map(user,UserDto.class);
           userDtoList.add(userDto);
        }
        return new ResponseEntity(userDtoList,HttpStatus.OK);
    }
}
