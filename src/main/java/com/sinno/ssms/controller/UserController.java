package com.sinno.ssms.controller;

import com.sinno.ssms.model.dto.UserDTO;
import com.sinno.ssms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import static com.sinno.ssms.mapper.UserMapper.USER_MAPPER;

@RestController
@CrossOrigin
@RequestMapping(path = "/user")
public class UserController
{

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable int id)
    {
        return USER_MAPPER.entity2dto(userService.findUserById(id));
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return USER_MAPPER.entity2dto(userService.createUser(userDTO));
    }

}