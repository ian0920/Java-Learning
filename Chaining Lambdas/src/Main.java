import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        String name = "tim";
        Function<String, String> uCase = String::toUpperCase;
        System.out.println(uCase.apply(name));

        Function<String, String> lastName = s -> s.concat(" Buchalka");
        System.out.println(lastName.apply(name));

        Function<String, String> uCaseLastName = uCase.andThen(lastName);
        System.out.println(uCaseLastName.apply(name));

        uCaseLastName = uCase.compose(lastName);
        System.out.println(uCaseLastName.apply(name));

        Function<String, String[]> f0 = uCase.andThen(lastName)
                .andThen(s-> s.split(" "));
        System.out.println(Arrays.toString(f0.apply(name)));

        Function<String, String> f1 = uCase.andThen(lastName)
                .andThen(s-> s.split(" "))
                .andThen(s-> s[1].toUpperCase()+", " + s[0]);
        System.out.println(f1.apply(name));

        Function<String, Integer> f2 = uCase.andThen(lastName)
                .andThen(s-> s.split(" "))
                .andThen(s-> String.join(", ", s))
                .andThen(String::length);


        System.out.println(f2.apply(name));


        // Consumer .andThen() , .compose(){ only in Function or UnaryOperator interface }

        String[] nameList = {"Ann", "Bob", "Chad", "Ella"};
        Consumer<String> s0 = s-> System.out.print(s.charAt(0));
        Consumer<String> s1 = System.out::println;

        Arrays.asList(nameList).forEach(s0
                .andThen(s-> System.out.print("-"))
                .andThen(s1));


        //Predicate .or() , .and() , .negate()


        Predicate<String> p0 = s-> s.equals("TIM");
        Predicate<String> p1 = s-> s.equalsIgnoreCase("Tim");
        Predicate<String> p2 = s-> s.startsWith("T");
        Predicate<String> p3 = s-> s.endsWith("e");

        System.out.println(p0.or(p2).test(name));

        record Person (String firstName, String lastName){}

        List<Person> list = new ArrayList<>(Arrays.asList(
                new Person("Peter", "Pan"),
                new Person("Peter", "PumpkinEater"),
                new Person("Minnie", "Mouse"),
                new Person("Mickey", "Mouse")
        ));

        list.sort((o1,o2)-> o1.lastName.compareTo(o2.lastName));
        //list.sort(Comparator.comparing(o -> o.lastName)); Lambda expression
        list.forEach(System.out::println);
        System.out.println("-------------------------------");


        list.sort(Comparator.comparing(Person::lastName));
        //comparing is a static method in Comparator interface  and pass a method reference to it.
        //The method reference implicitly accept Person instance and retrieves lastName field from that instance
        list.forEach(System.out::println);

        System.out.println("-------------------------------");
        list.sort(Comparator.comparing(Person::lastName).thenComparing(Person::firstName));
        list.forEach(System.out::println);

        System.out.println("-------------------------------");
        list.sort(Comparator.comparing(Person::lastName).thenComparing(Person::firstName).reversed());
        list.forEach(System.out::println);



        String [] fruit = {"apple","banana","grape"};

        ArrayList<String> fruitList = new ArrayList<>(Arrays.asList(fruit));

        fruitList.add("orange");
        System.out.println(fruitList);
        fruitList.contains("orange");



        ArrayList<String> fruitList2 = new ArrayList<>(List.of(fruit));

        fruitList2.add("pearl");
        System.out.println(fruitList2);


        List<String> fruitList3 = new ArrayList<>(Arrays.asList(fruit));
        fruitList3.add("tomato");
        System.out.println(fruitList3);

        Arrays.asList("a","b");

    }
}
