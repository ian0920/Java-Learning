package dev.lpa;

public class Parent {

    static {
        System.out.println("Parent Static Initializer in Parent : class is being constructed");
        //only called the first time this class is referenced or constructed

    }
    private final String name;
    private final String dob;
    protected final int siblings;

    //Instance Initializer
    {
//        this.name = "John Doe";
//        this.dob = "01/01/1900";
        System.out.println("In parent Initializer");

    }

//    public Parent() {
//        System.out.println("In parent's No Args Constructor");
//    }

    public Parent(String name, String dob, int siblings) {
        this.name = name;
        this.dob = dob;
        this.siblings = siblings;
        System.out.println("In parent's Constructor");
    }

    public String getName() {
        return name;
    }


    public String getDob() {
        return dob;
    }


    @Override
    public String toString() {
        return "name='" + name + '\'' + ", dob='" + dob + '\'';
    }
}
