import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

public class MainMapping {

    public static void main(String[] args) {

        Course pymc= new Course("PYMC", "Python Masterclass", 50);
        Course jmc= new Course("JMC", "Java Masterclass", 100);
        Course jgames= new Course("JGAME", "Creating Game in Java");


        List<Student> students =
                Stream.generate(() -> Student.getRandomStudent(pymc, jmc))
                        .limit(5000)
                        .collect(Collectors.toList());


        var mappedStudents =
                students.stream()
                        .collect(Collectors.groupingBy(Student::getCountryCode));

        mappedStudents.forEach((k, v) -> System.out.println(k + " " + v.size()));

        int min = 25;
        var under25 =
                students.stream()
                        .collect(Collectors.groupingBy(Student::getCountryCode
                        ,filtering(s -> s.getAge() <= min, toList())));


        under25.forEach((k, v) -> System.out.println(k + " " + v.size() + " students"));

        var experienced =
                students.stream()
                        .collect(partitioningBy(Student::hasProgrammingExperience));

        experienced.forEach((k, v) -> System.out.println(k + " " + v.size() + " students"));
        System.out.println("Experienced student = " + experienced.get(true).size());

        var expCount =
                students.stream()
                        .collect(partitioningBy(Student::hasProgrammingExperience, counting()));

        expCount.forEach((k, v) -> System.out.println(k + " " + v + " students"));

        var expAndActive =
                students.stream()
                        .collect(partitioningBy(
                                s -> s.hasProgrammingExperience() && s.getMonthsSinceActive() == 0, counting()));

        expAndActive.forEach((k, v) -> System.out.println(k + " " + v + " students"));

        var multiLevel = students.stream()
                .collect(groupingBy(Student::getCountryCode, groupingBy(Student::getGender, groupingBy(Student::hasProgrammingExperience))));


        multiLevel.forEach((key, value) -> {
            System.out.println(key);
            value.forEach((key1, value1) -> {
                System.out.println("\t" +key1);
                value1.forEach((key2, value2) -> {
                    System.out.println("\t    " + key2 + " " + value2.size());
                });
            });
        });


        long studentBodyCount = 0;

        studentBodyCount = experienced.values().stream()
                .map(l -> l.stream()
                        .filter(s ->s.getMonthsSinceActive() <= 3)
                        .count()
                ).mapToLong(l ->l)
                .sum();

        System.out.println("studentBodyCount = " + studentBodyCount);

        long count = experienced.values().stream()
                .flatMap(l -> l.stream())
                .filter(s ->s.getMonthsSinceActive() <= 3)
                .count();

        System.out.println("count = " + count);







    }
}
