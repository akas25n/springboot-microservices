package com.userservice.controller;

import com.userservice.entity.User;
import com.userservice.service.UserService;
import com.userservice.valueObject.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll(){
        log.info("Inside findAll() of UserController");
        return userService.findAllUser();
    }

    @PostMapping
    public User save(@RequestBody User user){
        log.info("Inside save() of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{userId}")
    public ResponseTemplate getUserWithDepartmentByUserId(@PathVariable long userId){
        return userService.getUserWithDepartmentByUserId(userId);
    }


}
