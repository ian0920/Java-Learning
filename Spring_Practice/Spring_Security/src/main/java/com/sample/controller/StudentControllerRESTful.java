package com.sample.controller;

import com.sample.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
public class StudentControllerRESTful {


    List<Student> students = new ArrayList<Student>(List.of(
            new Student("111", "111", "ian1", 11, "java"),
            new Student("222", "222", "ian2", 22, "hibernate"),
            new Student("333", "333", "ian3", 33, "spring"))
    );

    @GetMapping("/rest/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/rest/token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
        //YllTazRVnekUEnAGDVuaqgHYPmNswY_7v9kOML9aqyZz2GmuA2gwUlFmqNo5KxM3P3auz2XuEwJV977Wh-htB49izRZFvVma
    }

    @PostMapping("/rest/students")
    public void addStudent(@RequestBody Student student) {
        students.add(student);
        System.out.println(students);
    }

}
