import java.util.Calendar;

public class MainTest {

    public static void main(String[] args) {

//        String regex = "^[A-Z][12]\\d{8}";
//        Scanner scanner = new Scanner(System.in);
//        String id = scanner.next();

//        if (id.matches(regex)) {
//            System.out.println("good");
//        } else {
//            System.out.println("no good");
//        }

//        while (!id.matches(regex)){
//            System.out.println("no good");
//            id = scanner.next();
//        }
//
//        System.out.println("good");


//        question3();


        System.out.print("");

        Calendar rightNow = Calendar.getInstance();
        System.out.println(rightNow);

    }


    public static void question3() {
//			有個字串陣列如下 (八大行星):
//			{“mercury”, “venus”, “earth”, “mars”, “jupiter”, “saturn”, “uranus”, “neptune”}
//			請用程式計算出這陣列裡面共有多少個母音(a, e, i, o, u)

        String [] planet = {"mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune"};
        int counter = 0;

        for (int i = 0 ; i < planet.length; i++){
           String regex = "^.[aeiou].$";
           if (planet[i].matches(regex)){
           counter++;
           }
        }

        System.out.printf("共有%d個母音\n",counter);
    }





}
