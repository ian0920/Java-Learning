import java.util.*;

public class Main {

    public static void main(String[] args) {

        StringBuilder bobsNotes = new StringBuilder();
        StringBuilder billsNotes = new StringBuilder("Bill struggle with generics");

        Student bob = new Student("Bob", bobsNotes);
        Student bill = new Student("Bill", billsNotes);

        List<Student> students = new ArrayList<>(List.of(bob, bill));
        List<Student> studentFirstCopy = new ArrayList<>(students);
        List<Student> studentSecondCopy = List.copyOf(students);
        List<Student> studentThirdCopy = Collections.unmodifiableList(students); // the view of the passing list.

        studentFirstCopy.add(new Student("Bonnie", new StringBuilder()));
//        studentSecondCopy.add(new Student("Bonnie", new StringBuilder()));
        studentFirstCopy.sort(Comparator.comparing(Student::getName));
        students.add(new Student("Bonnie", new StringBuilder()));

        StringBuilder bonniesNotes = studentFirstCopy.get(2).getStudentNotes();
        bonniesNotes.append("Bonnie is taking 2 of my courses");

        bobsNotes.append("Bob was one of my first students");

        students.forEach(System.out::println);
        System.out.println("----------------------");
        studentFirstCopy.forEach(System.out::println);
        System.out.println("----------------------");
        studentSecondCopy.forEach(System.out::println);
        System.out.println("----------------------");
        studentThirdCopy.forEach(System.out::println);
        System.out.println("----------------------");





    }
}
