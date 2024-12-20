package org.example;

public class Alien {

    private int age;
    private int size;
    private Computer computer;

    public Alien() {
        System.out.println("Alien object created");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("alien setter being called");
        this.age = age;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public void code(){
        computer.compile();
    }

    @Override
    public String toString() {
        return "Alien{" +
                "age=" + age +
                ", lap=" + computer +
                '}';
    }
}
