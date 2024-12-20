package org.artogether;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTest {

    @RequestMapping("/")
    public String index() {
        System.out.println("index page called");
        return "index";
    }
}
