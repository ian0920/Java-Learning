public class Module_8 {

    public static void main(String[] args) {

/*
        for loop ：

        for (初值設定; 條件判斷; 計次){
            敘述...
        }



        while loop ：

        while (條件判斷){
            敘述...
        }



        do while loop ：

        do {
            敘述...
        } while (條件判斷);



*/

        nineNineLoop(3);



    }

    public static void nineNineLoop (int times){

        int a = 0;

        while (a != times){

            int i, j;
            for (i = 1; i <= 9; i++) {
                for (j = 1; j <= 9; j++)
                    System.out.print(i + "*" + j + "=" + i * j + "\t");
                System.out.println();
            }

            System.out.println();

            a++;
        }



    }
}
