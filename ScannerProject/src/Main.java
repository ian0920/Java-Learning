import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {




        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("fixedWidth.txt")))) {

//            while(scanner.hasNextLine()){
//                ys   Stem.out.println(scanner.nextLine());
//            }


//            System.out.println(scanner.delimiter());
//            scanner.useDelimiter("$");
//            scanner.tokens().forEach(System.out::println);

//            scanner.findAll("[A-Za-z]{10,}")
//                    .map(MatchResult::group)
//                    .distinct()
//                    .sorted()
//                    .forEach(System.out::println);


            var result = scanner.findAll("(.{15})(.{3})(.{12})(.{8})(.{2}).*")
                    .map(m -> m.group(3).trim())
                    .skip(1)
                    .distinct()
                    .sorted()
                    .toArray(String[]::new);

            System.out.println(Arrays.toString(result));



        }catch (IOException e){
            e.printStackTrace();
        }




    }
}
