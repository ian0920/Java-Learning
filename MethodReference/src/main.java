import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

class PlainOld{

    private static int last_id = 1;
    private int id;

    public PlainOld(){
        id = PlainOld.last_id++;
        System.out.println("Creating a Plain Old Object: id = " + id);
    }

}
public class main {

    public static void main(String[] args) {

        // Method reference for instance method (bounded receiver)

        List<String> list = new ArrayList<>(List.of("Anna","Bob", "Chuck", "Dave"));
        list.forEach(s-> System.out.println(s));
        list.forEach(System.out::println);// replace lambda expression with method reference


        // Method reference for static method

        calculator((a,b)->a+b, 5,2);
        //Second type of method reference, using static method on a class, with class type as the reference.
        calculator(Integer::sum, 5,2);// sum is a static method in the Integer wrapper class
        // apply method is override like
        //@override
        // T apply(T1, T2){ return t1+t2 }

        calculator(Double::sum, 10.0, 2.5);

        // Method reference for constructor

        // Supplier method T get(), take no parameter but return a T type.
        Supplier<PlainOld> reference1 = () -> new PlainOld(); // a constructor of method reference
                                        // this calls the empty constructor and create a new instance of PlainOld object

        // if you create a variable that are lambda expression or method reference, it's not invoked at that time

        PlainOld newPoJo = reference1.get();


        var PlainOldList = seedArray(PlainOld::new, 5);


        // Method reference for instance method (Unbounded receiver)

        calculator((s1, s2)-> s1 + s2, "Hello ", "World");
        calculator((s1, s2)-> s1.concat(s2), "Hello ", "World");
        calculator(String::concat, "Hello ", "World");

        //BinaryOperator<String> b1 = (s1,s2) -> s1.concat(s2);
        BinaryOperator<String> b1 = String::concat;
        //BiFunction<String, String, String> b2 = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> b2 = String::concat;
        UnaryOperator<String> u1 = String::toUpperCase;

        System.out.println(b1.apply("Hello ", "World"));
        System.out.println(b2.apply("Hello ", "World"));
        System.out.println(u1.apply("Hello "));


        String result = "hahahaha".transform(u1);
        System.out.println("transForm method result= " + result);

        result = result.transform(String::toLowerCase);
        System.out.println(result);

        Function<String, Boolean> f0 = String::isEmpty; //s-> s.isEmpty();
        boolean resultBoolean = result.transform(f0);
        System.out.println(resultBoolean);

    }



    private static <T> void calculator (BinaryOperator<T> function, T t1,T t2){

        T result = function.apply(t1, t2);
        System.out.println("Result of operation: " + result);

    }

    private static PlainOld[] seedArray (Supplier<PlainOld> reference, int count){

        PlainOld[] newArray = new PlainOld[count];
        Arrays.setAll(newArray, i -> reference.get());

//        for(int i = 0 ; i<count;i++ ){
//            newArray[i] = reference.get();
//        } my own solution, also works!

       return newArray;
    }
}
