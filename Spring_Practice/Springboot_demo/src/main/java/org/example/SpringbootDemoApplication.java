package org.example;

import org.example.model.Programmer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringbootDemoApplication.class, args);

        Programmer p1 = context.getBean(Programmer.class);
        System.out.println(p1.getAge());
        p1.code();


    }

}
