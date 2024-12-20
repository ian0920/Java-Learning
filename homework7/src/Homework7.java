import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Homework7 {

    public static void main(String[] args) {


        question1();

    }

    public static void question1 () {

        File file = new File("Sample.txt");

//		System.out.print(file.getAbsolutePath());

        try {
            FileReader ir = new FileReader(file);
            BufferedReader br = new BufferedReader(ir);
            String text = "";
            int i;
            int numOfChar = 0;
            String c ="";
            int lines = -1;

            while ((i = br.read()) != -1) {
//                System.out.print((char)i);
                numOfChar++;
            }


            System.out.printf("Sample.txt檔案共有%d個位元組，%d個字元，%d列資料", file.length(), numOfChar, lines);
//            br.close();
            ir.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
