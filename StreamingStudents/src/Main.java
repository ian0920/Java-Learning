import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Course pymc= new Course("PYMC", "Python Masterclass");
        Course jmc= new Course("JMC", "Java Masterclass");

//        Student tim = new Student("AU", 2023, 30, "M",
//                true, jmc, pymc);
//        System.out.println(tim);
//
//        tim.watchLecture("JMC", 10, 5, 2023);
//        tim.watchLecture("PYMC", 7, 7, 2024);
//        System.out.println(tim);

        Student[] students = new Student[1000];
        Arrays.setAll(students, s -> Student.getRandomStudent(jmc, pymc));

        var maleStudents = Arrays.stream(students)
                .filter( s -> s.getGender().equals("M"))
                .count();

        System.out.println("Male students are " + maleStudents + " in total.");

        var femaleStudents = Arrays.stream(students)
                .filter(s -> s.getGender().equals("F"))
                .count();

        System.out.println("Female students are " + femaleStudents + " in total.");

        var unknownStudents = Arrays.stream(students)
                .filter(s -> s.getGender().equals("U"))
                .count();

        System.out.println("unknown students are " + unknownStudents + " in total.");

        for(String gender : List.of("M", "F","U")){

            var student = Arrays.stream(students)
                    .filter(s -> s.getGender().equals(gender))
                    .count();

            System.out.println("# of " + gender + " students " + student);
        }

        var less30 = Arrays.stream(students)
                .filter(s -> s.getAge() <= 30)
                .count();

        System.out.println(less30 + " students are less than 30.");

        var between30To60 = Arrays.stream(students)
                .filter(s -> 30 < s.getAge() && s.getAge() <= 60)
                .count();

        System.out.println(between30To60 + " students are between 30 to 60.");

        var over60 = Arrays.stream(students)
                .filter(s -> s.getAge() > 60)
                .count();

        System.out.println(over60 + " students are over 60.");


        var ageStream = Arrays.stream(students)
                .mapToInt(Student::getAgeEnrolled);

        System.out.println("state for enrollment age = " + ageStream.summaryStatistics());

        var currentAgeStream = Arrays.stream(students)
                .mapToInt(Student::getAge);

        System.out.println("state for current age = " + currentAgeStream.summaryStatistics());

        boolean longTerm = Arrays.stream(students)
                .anyMatch(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12 ));
        System.out.println( "Long Tern students?　" + longTerm);

        long longTermCount = Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12 ))
                .count();
        System.out.println( "Long Tern students?　" + longTermCount);

        Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12 ))
                .filter(s-> !s.hasProgrammingExperience())
                .limit(5)
                .forEach(System.out::println);


        Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12 ))
                .filter(s-> !s.hasProgrammingExperience())
                .limit(5)
                .toList()
                .forEach(System.out::println);


        var longYearLearners = Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12 ))
                .filter(s-> !s.hasProgrammingExperience())
                .limit(5)
                .toArray(Student[]::new);

        var learners = Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12 ))
                .filter(s-> !s.hasProgrammingExperience())
                .limit(5)
                .collect(Collectors.toList());





    }


}
