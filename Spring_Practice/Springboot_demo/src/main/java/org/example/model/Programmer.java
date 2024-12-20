package org.example.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Programmer {

    //@Value("31") Field injection
    private int age;

    private Computer com;

    public int getAge() {
        return age;
    }

    @Value("31")
    public void setAge(int age) {
        this.age = age;
    }

    public Computer getCom() {
        return com;
    }

    @Autowired // Setter injection
    @Qualifier("desktop") //小寫的Class type
    public void setCom(Computer com) {
        this.com = com;
    }

    public void code(){
        com.compile();
    }
}
