import java.util.*;

public class Main {

    record Person (String firstName, String lastName){
        //record is implicitly set to static as interface and enum in the inner class

        @Override
        public String toString() {
            return firstName + " " +lastName;
        }
    }

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("Lucy", "Van Pelt"), // Because Person is static nested class of main, we could access it via Main clas
                new Person("Sally", "Brown"),
                new Person("Linus", "Van Pelt"),
                new Person("Peppermint", "Patty"),
                new Person("Charlie", "Brown")));



        // Using anonymous class

        var comparatorLastName = new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName.compareTo(o2.lastName);
            }
        };

        people.sort(comparatorLastName);
        System.out.println(people);




        //Comparator and Comparable parts

        Integer five = 5;
        Integer[] other = {0,5,10,-50,50};

        for (Integer i : other){

            int val = five.compareTo(i);
            System.out.println(" 5 compare to " +i + " = "+ val);

        };

        String a = "Banana";
        String [] fruit = {"Apple", "APPLE", "Banana", "BANANA","peach","Pearl"};

        for (String i : fruit){

            int val = a.compareTo(i);
            System.out.println( "Banana compare to " + i + " = " + val);

        };


        Arrays.sort(fruit);
        System.out.println(Arrays.toString(fruit));

        Student ian = new Student("ian");

        Student [] studentList = { new Student("ian"),new Student("tim"),new Student("ann")};

        Arrays.sort(studentList);
        System.out.println(Arrays.toString(studentList));

        System.out.println("Result" + ian.compareTo(new Student("tim")));



        //Comparator method

        // Create an instance as comparator
        Comparator<Student> gpaStudent = new gpaComparator();

        Arrays.sort(studentList,gpaStudent);
        System.out.println("Create an instance as comparator: " + Arrays.toString(studentList));


        //Using Anonymous class
        // the type var here is actually an anonymous class type that implement Comparator interface
        // so gpaStudent2 is a instance of anonymous class
        var gpaStudent2 = new Comparator<Student>(){  //using an anonymous inner class that implement Comparator interface
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.gpa == o2.gpa){
                    return o1.name.compareTo(o2.name);
                }
                return Double.valueOf(o1.gpa).compareTo(Double.valueOf(o2.gpa));
            }
        };

        Arrays.sort(studentList,gpaStudent2);
        System.out.println("Using Anonymous class: " + Arrays.toString(studentList));




        //Using Lambda Expression
        Arrays.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {

            if(o1.gpa == o2.gpa){

                return o1.name.compareTo(o2.name);
            }
            return Double.valueOf(o1.gpa).compareTo(o2.gpa);
            }
        });

        System.out.println("Using before Lambda Expression: " + Arrays.toString(studentList));


        //Using Lambda Expression
        Arrays.sort(studentList, (o1, o2) -> {

            if(o1.gpa == o2.gpa){

                return o1.name.compareTo(o2.name);
            }
            return Double.valueOf(o1.gpa).compareTo(o2.gpa);
        });

        System.out.println("Using after Lambda Expression: " + Arrays.toString(studentList));

    }
}

class gpaComparator implements Comparator <Student>{


    @Override
    public int compare(Student o1, Student o2) {

        if(o1.gpa == o2.gpa){

            return o1.name.compareTo(o2.name);
        }
        return Double.valueOf(o1.gpa).compareTo(o2.gpa);
    }
}

class Student implements Comparable <Student>{

    protected String name ;
    private static int LAST_ID = 1000;
    private int id;
    protected double gpa ;
    private static Random random = new Random();


    public Student(String name) {
        this.name = name;
        id = LAST_ID++;
        gpa = random.nextDouble(1.0,4.0);
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id,name,gpa);
    }


    @Override
    public int compareTo(Student o) {
//        return name.compareTo(o.name);
//        return this.id.compareTo(o.id); id as a primitive type int, can't be used in interface
        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
    }
}