package com.sample.service;

import com.sample.dao.UserRepo;
import com.sample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public User addUser(User user) {

        user.setPassword(encoder.encode(user.getPassword()));

        return userRepo.save(user);
    }

}
