package org.example;

public class Laptop implements Computer{

    int number;

    public Laptop() {
        System.out.println("Laptop object created");
    }

    @Override
    public void compile(){
        System.out.println("compiling using laptop");
    }
}
