import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class main {

    public static void main(String[] args) {

        //Challenge 1 turn an anonymous class into lambda expression

//        Consumer<String> printTheParts = new Consumer<String>() {
//            @Override
//            public void accept(String sentence) {
//                String [] parts = sentence.split(" ");
//                for (String part : parts){
//                    System.out.println(part);
//                }
//            }
//        };

        //1. Consumer -> void accept (T t);
        Consumer<String> printTheParts = sentence -> {
                String [] parts = sentence.split(" ");
                for (String part : parts){
                    System.out.println(part);
                }
        };

        printTheParts.accept("Let's split up the words");

        //change for loop into forEach
        Consumer<String> printThePartsForEach = sentence -> {
            String [] parts = sentence.split(" ");
            Arrays.asList(parts).forEach(s -> System.out.println(s) );
        };

        printThePartsForEach.accept("This is using forEach method");

        //make the expression more concise
        Consumer<String> printThePartsConcise = sentence -> {
            Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s) );
        };

        printThePartsConcise.accept("This is more concise");


        //Challenge 2
        //UnaryOperation <T> -> T apply (T t);

        UnaryOperator<String> secondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        //Challenge 3
        System.out.println(secondChar.apply("0123456789"));

        //Challenge 5

        System.out.println(everySecondCharacter(secondChar, "1234567890"));


        //Challenge 6

        Supplier<String> iLoveJava = ()-> "I Love Java";
        var supplierResult = iLoveJava;

        System.out.println(iLoveJava.get());











    }

    //Challenge 2 Write the following method as a lambda expression
    public static String everySecondChar (String source){

        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i<source.length(); i++){
            if( i % 2 == 1){
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    // Challenge 4
    public static String everySecondCharacter (UnaryOperator<String> function, String source){

         return function.apply(source);

    }
}
