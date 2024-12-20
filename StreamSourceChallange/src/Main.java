import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {

        Stream.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)
                .map(s -> "B - " + s)
                .forEach(System.out::println);

        String[] second = new String[15];
        for(int i = 0; i<15 ; i++){
            second[i] = i+16+"";
        }

        Arrays.stream(second)
                .map(s -> "I - " + s)
                .forEach(System.out::println);

        Stream.iterate(31, i-> i<=45, i->i+1)
                .map(s-> "N - " + s)
                .forEach(System.out::println);

        Stream.generate(()-> new Random().nextInt(46, 61))
                .distinct()
                .limit(15)
                .sorted()
                .map(s -> "G - " + s)
                .forEach(System.out::println);



    }



}
