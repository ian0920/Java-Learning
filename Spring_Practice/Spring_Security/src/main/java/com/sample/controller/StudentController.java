package com.sample.controller;

import com.sample.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    List<Student> students = new ArrayList<Student>(List.of(
            new Student("111", "111", "ian1", 11, "java"),
            new Student("222", "222", "ian2", 22, "hibernate"),
            new Student("333", "333", "ian3", 33, "spring"))
    );

    @GetMapping("students")
    public String getStudents(Model model) {
        model.addAttribute("students", students);
        return "students";
    }
}
