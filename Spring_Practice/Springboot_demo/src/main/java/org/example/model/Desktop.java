package org.example.model;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer{

    @Override
    public void compile(){
        System.out.println("Compiling on desktop");
    }
}
