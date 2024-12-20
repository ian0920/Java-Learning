import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainOptional {

    public static void main(String[] args) {

        Course pymc= new Course("PYMC", "Python Masterclass", 50);
        Course jmc= new Course("JMC", "Java Masterclass", 100);
        Course jgames= new Course("JGAME", "Creating Game in Java");


        List<Student> students =
                Stream.generate(() -> Student.getRandomStudent(pymc, jmc))
                        .limit(5000)
                        .collect(Collectors.toList());

        Optional<Student> o1 = getStudent(new ArrayList<>(), "first");
        System.out.println("Empty = " + o1.isEmpty() + " Present = " + o1.isPresent());
        System.out.println(o1);
//        System.out.println(o1.get());
        o1.ifPresentOrElse(System.out::println, () -> System.out.println("----> empty"));

        Optional<Student> o2 = getStudent(students, "first");
        System.out.println("Empty = " + o2.isEmpty() + " Present = " + o2.isPresent());
        System.out.println(o2);
        o2.ifPresent(System.out::println);

//        Student firstStudent = o2.orElse(getDummyStudent(jmc));
        Student firstStudent = o2.orElseGet(() -> getDummyStudent(jmc));
        long studentId = firstStudent.getStudentId();
        System.out.println("first student's ID = " + studentId);


        List<String> countries = students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .toList();

        Optional.of(countries)
                .map(l -> String.join(", ", l))
                .filter(l -> l.contains("FR"))
                .ifPresentOrElse(System.out::println, () -> System.out.println("Missing FR"));


    }

    private static Optional<Student> getStudent (List<Student> list, String type){

        if (list == null || list.size() == 0){
            return Optional.empty();
        }else if (type.equals("first") ){
            return Optional.ofNullable(list.get(0));
        } else if (type.equals("last")) {
            return Optional.ofNullable(list.get(list.size() - 1));
        }
        return Optional.ofNullable(list.get(new Random().nextInt(list.size())));
    }

    private static Student getDummyStudent (Course... courses){

        System.out.println("Getting the dummy student");
        return new Student("No", 1, 1, "U", false, courses);

    }
}
