import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class main {

    public static void main(String[] args) {


        //Consumer interface

        //1. Consumer -> void accept (T t);
        // Lambda expression { s -> System.out.print(s) }

        var coords = Arrays.asList(
                new double[] {47.2610, -95.2348},
                new double[] {29.1566, -89.2495},
                new double[] {35.1556, -90.0695});

        coords.forEach(s-> System.out.println(Arrays.toString(s)));

        int result = calculator((a,b)->a+b, 5,2);
        var result2 = calculator((a,b)->a/b, 10.0,2.5);
        var result3 = calculator(
                (a,b)-> a.toUpperCase() + " " + b.toUpperCase(), "Ian", "Hsu");


        System.out.println("----Consumer interface (Consumer)----");

        //2. BiConsumer -> void accept (T t, U u);


        // using anonymous class to override the method of interface

//        BiConsumer<Double,Double> p1 = new BiConsumer<Double, Double>() {
//            @Override
//            public void accept(Double lat, Double lng) {
//                System.out.printf("[lat : %.3f lng : %.3f]%n", lat, lng);
//            }
//        };

        //using lambda expression

        BiConsumer<Double,Double> p1 = (lat, lng) ->
                System.out.printf("[lat : %.3f lng : %.3f]%n", lat, lng);



        var firstPoint = coords.get(0);
        processPoint(firstPoint[0],firstPoint[1],p1);

        coords.forEach( s-> processPoint(s[0],s[1],p1));
        System.out.println("----Consumer interface (BiConsumer)----");

        //Predicate interface

        //1. Predicate -> boolean test (T t);

        List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta"));

        list.removeIf(s -> s.equalsIgnoreCase("bravo"));

        System.out.println(list);

        list.addAll(List.of("echo","easy", "earnest"));
        list.forEach(s -> System.out.println(s));
        System.out.println("-------");

        list.removeIf(s -> s.startsWith("ea"));
        list.forEach(s -> System.out.println(s));

        //implementation of Predicate interface
        Predicate<String> checkString = String -> String.length()>5;
        System.out.println(checkString.test("hahahahah"));

        System.out.println("----Predicate interface ----");

        //2. BiPredicate -> boolean test (T t, U u);



        //Function interface

        //1. Function <T, R> -> R apply (T t);
        //2. BiFunction <T, U, R> -> R apply (T t, U u);
        //3. UnaryOperator <T> -> T apply (T t);
        //3. BinaryOperator <T> -> T apply (T t1, T t2);


        //UnaryOperation
        list.replaceAll( s -> s.charAt(0) + " - " + s.toUpperCase());
        System.out.println(list);
        list.forEach(s -> System.out.println(s));

        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings));
        Arrays.fill(emptyStrings," ");
        System.out.println(Arrays.toString(emptyStrings));
        Arrays.setAll(emptyStrings, i -> "" + (i+1) + "." + // take the index of array as argument
                switch (i) {
                    case 0 -> "one";
                    case 1 -> "two";
                    case 2 -> "three";
                    default -> "";
                });
        System.out.println(Arrays.toString(emptyStrings));


        //Supplier interface

        //1. Supplier -> T get(); take no argument but return an instance of some type T.

        String[] name = {"Ann", "Bob", "Carol", "Ed","Fred"};
        String[] random = randomlySelectedValues(15,name,()-> new Random().nextInt(0, name.length));
        System.out.println(Arrays.toString(random));


    }



    public static <T> T calculator (BinaryOperator<T> function , T value1, T value2){

        T result = function.apply(value1,value2);
        System.out.println("Result of operation = " + result);
        return result;

    }

    public static <T> void processPoint (T t1, T t2, BiConsumer<T, T> consumer){

        consumer.accept(t1,t2);
    }

    public static String[] randomlySelectedValues (int count, String[] value, Supplier<Integer> s){

        String[] selectedValues = new String [count];

        for(int i = 0; i < count; i++ ){
            selectedValues[i] = value[s.get()];
        }
        return selectedValues;
    }
}
