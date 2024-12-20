import java.util.*;
import java.util.function.UnaryOperator;

public class main {

    private static Random random = new Random();

    private record Person (String first){

        public String last (String s){
            return first + " " + s.substring(0,s.indexOf(" "));
        }

    }


    public static void main(String[] args) {

        String[] names = {"Ana","Bob", "Chuck", "David", "Eric"};
        Person tim = new Person("Tim");

        List<UnaryOperator<String>> list = new ArrayList<>(List.of(

                String::toUpperCase,
                s-> s += " " + getRandomChar('a','z') +".",
                s-> s += " " + reverse(s,0, s.indexOf(" ")),
                main::reverse,
                String::new,
                String::valueOf,
                tim::last, //s-> tim.last(s)
                (new Person("Mary"))::last // instance method called on in instance(4 type of method reference)


        ));

        applyChanges(names,list);


    }



    public static void applyChanges (String[] names, List<UnaryOperator<String>> stringFunction){

        List<String> backedByArray = Arrays.asList(names);
        for (var function : stringFunction){
            backedByArray.replaceAll(s->s.transform(function));
            System.out.println(Arrays.toString(names));
        }


    }



    private static char getRandomChar (char start, char end){

        return (char)random.nextInt((int)start, (int)end+1);

    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }



    private static String reverse(String s, int start, int end) {
        return new StringBuilder(s.substring(start,end)).reverse().toString();
    }
}



