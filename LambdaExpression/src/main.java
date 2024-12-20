import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta"));

        for (String s : list){
            System.out.println(s);
        }

        System.out.println("------------");

        list.forEach(System.out::println);

        System.out.println("------------");

        list.forEach((var myString) -> {
            char firstChar = myString.charAt(0);
            System.out.println( myString + " means " + firstChar);

        });


        int result = calculator((a,b)->a+b, 5,2);
        var result2 = calculator((a,b)->a/b, 10.0,2.5);
        var result3 = calculator(
                (a,b)-> a.toUpperCase() + " " + b.toUpperCase(), "Ian", "Hsu");


        //Operation <T> function -> (a,b)->a+b

        //anonymous class implement Operation interface, and override the operate method
        // aClass function = new aClass (){ override method expression }
        // aClass function = (a,b)->a+b
        // (a,b)->a+b take lambda expression as parameter
        // lambda expression can be used to represent an instance of a functional interface
        var function = new Operation<Integer>(){ // using an anonymous class that implement Operation interface and overrider the method
            @Override
            public Integer operate(Integer value1, Integer value2) {
                return value1 + value2;
            }
        };



    }


    public static <T> T calculator (Operation<T> function ,T value1, T value2){

        T result = function.operate(value1,value2);
        System.out.println("Result of operation = " + result);
        return result;

    }
}
