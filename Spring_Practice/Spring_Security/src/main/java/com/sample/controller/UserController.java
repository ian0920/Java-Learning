package com.sample.controller;

import com.sample.model.User;
import com.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("rest/register")
    public User regiserUser(@RequestBody User user) {

        return userService.addUser(user);
    }

}
