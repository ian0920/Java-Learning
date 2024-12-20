package com.sample.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControllerRESTful {


    @GetMapping("/rest")
    public String restHome(HttpSession session){

        return "restHome" + session.getId();
    }

}
