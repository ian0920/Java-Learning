import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try (FileReader read = new FileReader("file.txt")){
            char [] block = new char [1000];
            int data;
            while ((data = read.read(block)) != -1){
                String content = new String(block, 0, data);
                System.out.printf("---> [%d char] %s%n", data, content);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("-----------------------------------------------");


        try (BufferedReader bufferedReader = new BufferedReader( new FileReader("file.txt"))){

//            String line;
//            while( (line = bufferedReader.readLine()) != null){
//                System.out.println(line);
//            }

            bufferedReader.lines().forEach(System.out::println);

        } catch (IOException e){
            e.printStackTrace();
        }


    }
}
