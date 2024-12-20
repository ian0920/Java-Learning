package org.example;

import java.beans.ConstructorProperties;

public class Alien2 {
    int age;
    Computer computer;

    @ConstructorProperties({"age", "computer"})
    public Alien2(int age, Computer computer) {
        System.out.println("Alien2 Constructor Injection called");
        this.age = age;
        this.computer = computer;
    }
}
