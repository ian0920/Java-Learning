package dev.lpa;

public record Person(String name, String dob) {
//
//    {
//        this.dob = "01/01/1900";  Instance initializer is not allowed in record
//    }

    //Canonical constructor
//    public Person(String name, String dob) {
//        this.name = name;
//        this.dob = dob.replace('-', '/');
////        this.dob = dob.trim(); all field in Record are final
//    }

    public Person(Person p) {
        this(p.name, p.dob);
    }

    //compact constructor

    public Person {

        if (dob == null) throw new IllegalArgumentException("Bad Date");
        dob = dob.replace('-', '/');

        //can't do assignment to the instance fields in this constructor
        // the implicit canonical constructor's assignments occur after the execution of this code
    }
}
