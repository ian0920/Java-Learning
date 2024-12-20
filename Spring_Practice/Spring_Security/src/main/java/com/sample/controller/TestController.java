package com.sample.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {

        String sessionId = session.getId();
        model.addAttribute("sessionId", sessionId);

        System.out.println(session.getId());
        return "home";
    }


}
