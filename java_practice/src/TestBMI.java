import java.util.Scanner;

public class TestBMI {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your weight：" );
        int weight = scanner.nextInt();
        System.out.println("Enter your height in meter： ");
        double height = scanner.nextDouble();

        double bmi = weight / (height*height);


        if(bmi < 18.5){
            System.out.println("過瘦");
        }else if (bmi < 24){
            System.out.println("正常");
        }else {
            System.out.println("過重");
        }


    }
}
