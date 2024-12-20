import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class MainChallenge {
    public static void main(String[] args) {

        Course pymc= new Course("PYMC", "Python Masterclass", 50);
        Course jmc= new Course("JMC", "Java Masterclass", 100);
        Course jgames= new Course("JGAME", "Creating Game in Java");


        List<Student> students =
                Stream.generate(() -> Student.getRandomStudent(pymc, jmc))
                        .limit(5000)
                        .toList();

        double totalPercent = students.stream()
                .mapToDouble(s -> s.getPercentComplete("JMC"))
                .reduce(0, Double::sum);

        double avePercent = totalPercent / students.size();

        System.out.printf("Average Percentage Completed = %.2f%% %n", avePercent);

        var hardWorkers = students.stream()
                .filter(s -> s.getPercentComplete("JMC") > avePercent*1.25)
                .filter(s -> s.getMonthsSinceActive() == 0)
                .toList();

        System.out.println("Hard work students = " + hardWorkers.size());

        Comparator<Student> longTermStudent = Comparator.comparing(Student::getYearEnrolled);

        List<Student> hardWorkers2 = students.stream()
                .filter(s -> s.getPercentComplete("JMC") >= avePercent*1.25)
                .filter(s -> s.getMonthsSinceActive() == 0)
                .limit(10)
                .sorted(longTermStudent)
                .toList();

        hardWorkers2.forEach(s -> {
            s.addCourse(jgames);
            System.out.println(s);
        });









    }
}
