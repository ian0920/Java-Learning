package org.example;

import org.springframework.stereotype.Component;

@Component
public class Pad implements Computer{

    private String name;
    private int price;



    @Override
    public void compile() {
        System.out.println("using pad");
    }
}
