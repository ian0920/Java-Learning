package org.artogether.bueiness_member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BusinessController {


    @RequestMapping("/login")
    public String login(){
        return "index";
    }
}
