import java.util.Arrays;
import java.util.Random;

public class pickRandom {



    public static void main(String[] args) {

        /*      1. 使用前請先記得import以下三個package置於最上方
         *           import java.util.Arrays;
         *           import java.util.Random;
         *           import java.util.Scanner;
         *
         *       2. 可輸入想排除的號碼，程式會隨機挑選剩餘的號碼 (號碼範圍請在1~52號)
         *          輸入號碼以 , 相隔不同號碼，若無輸入則由程式自動選出7個隨機號碼
         *          ex: pickRandom(53,54,55...);
         *
         *       3. 第二輪選號時，請輸入第一輪當選的號碼，再加上你想排除的號碼，程式會隨機選出剩餘號碼
         *          若只輸入第一輪當選號碼，則由程式隨機選出7個號碼
         *
         *
         *       4. 選擇組長為專題製作的大事，好的組長帶你上天堂，請依據同學的能力、品行來謹慎選擇自己認為合適的組長人選
         *          此程式僅為輔助使用，如使用上有任何問題歡迎提出與我(51號)討論。
         *
         */


        pickRandom(); // 第二輪選號請記得將第一輪勝出的號碼輸入以避免再次選到

    }

    public static void pickRandom (){

        Random random = new Random();

        int[] array = new int[53];
        for (int i = 0; i < array.length; i++){
            array[i] = i;
        }

        int count =0;
        int selected[] = new int[7];

        while (count < 7){

            int pick = random.nextInt(1, 53);
            if(array[pick] != 0){
                selected[count] = array[pick];
                array[pick] = 0;
                count++;
            }
        }
        System.out.println("隨機號碼為: " + Arrays.toString(selected));


    }

    public static void pickRandom (int... exclusion){


        Random random = new Random();
        int[] deleted = exclusion;

        int[] array = new int[53];
        for (int i = 0; i < array.length; i++){
            array[i] = i;
        }

        for (int i = 0; i < deleted.length; i++){
            array[deleted[i]] = 0;
        }

        if (deleted.length > 7){

            int count = 0 ;
            int selected[] = new int[14 - deleted.length];

            while (count < (14 - deleted.length)){

                int pick = random.nextInt(1, 53);
                if(array[pick] != 0){
                    selected[count] = array[pick];
                    array[pick] = 0;
                    count++;
                }
            }
            System.out.println("你排除的號碼: " + Arrays.toString(deleted));
            System.out.println("隨機號碼為: " + Arrays.toString(selected));
            return;

        }

        int count = 0 + deleted.length;
        int selected[] = new int[7 - deleted.length];

        while (count < 7 ){

            int pick = random.nextInt(1, 53);
            if(array[pick] != 0){
                selected[count - deleted.length] = array[pick];
                array[pick] = 0;
                count++;
            }
        }
        System.out.println("你排除的號碼: " + Arrays.toString(deleted));
        System.out.println("隨機號碼為: " + Arrays.toString(selected));


    }
}
