public class Module_6 {

    public static void main(String[] args) {

/*
    運算子及運算元

        1. 運算子可針對一個以上的運算元進行運算，運算後的結果稱為回傳值
        2. 回傳值型態依照運算元而定

    算數運算子

        + ：加法運算 exception: String + int 為字串的串接
        - ：減法運算
        * ：乘法運算
        / ：除法運算
        % (modulo)：餘數運算 ex a % b 為a/b的餘數

        **若兩個運算元為基本型別，至少會轉換成int型別

*/
        //範例：

        int num1 = 5, num2 = 2;
        double numD = 2.0;
        System.out.println(num1 + num2);
        System.out.println(num1 - num2);
        System.out.println(num1 * num2 * numD); // output: 20.0 若運算元的位階不相等，則運算完後的回傳值會與位階高者相同
        System.out.println(num1 / num2); // output: 2 只回傳整數部分
        System.out.println(num1 / numD); // output: 2.5
        System.out.println(num1 % num2);
        System.out.println("現在是" + num1 + "點"); //output：現在是5點
        System.out.println("===============");

        short s1 = 100;
        short s2 = 1000;
        // short sum = s1+s2; 會報錯，為了避免溢位(overflow)的情況發生。
        // 若兩個運算元為基本型別，至少會轉換成int型別

/*
        遞增遞減運算子

            (後置型)++ ：a++  a = a+1
            (後置型)-- ：a--  a = a-1
            (前置型)++ ：a++  a = a+1
            (前置型)-- ：a--  a = a-1

            後置型(a++)：先取值後再遞增；前置型(++a)：先遞增後再取值
*/

        //範例：

        int a = 3;
        System.out.println(a++); //output:3 先取值再遞增
        System.out.println(a); // output:4 遞增後的結果

        int b = 3;
        System.out.println(++b); // output:4 先遞增再取值
        System.out.println(b); // output: 4 遞增後的結果


/*
        指定運算子

            1. “ = ”並非數學上”等於”的意思，而是”指定”的意思
            2. 等號右邊的型別位階不可以超過等號左邊的型別位階

             = ： a = 2      a = 2
            += ： a += 2     a = a + 2
            -= ： a -= 2     a = a - 2
            *= ： a *= 2     a = a * 2
            /= ： a /= 2     a = a / 2
            %= ： a %= 2     a = a % 2



*/


/*
        關係運算子

            1. 用來比較兩個變數的值，其回傳值結果是一個布林值(true / false)

             < ： a < b      a 是否小於 b
            <= ： a <= b     a 是否小於等於 b
            == ： a == b     a 等於 b
            != ： a != b     a 不等於 b
            >= ： a >= 2     a 是否大於等於 b
             > ： a > 2      a 是否大於 b

*/

/*
        條件運算子

            1. 將兩個布林值合併起來的運算子，運算結果仍為布林值

            && ： a && b     a 和 b 都是true 才回傳true
            || ： a || b     a 或 b 只要有一方為true 就會回傳true
             ! ：   !a       回傳相反的布林值

             用兩個 & (|) 進行合併，因為JAVA會執行時會用"短路(shortcut)運算"的邏輯進行
*/



/*
        資料型別晉升與轉換

            晉升(Promotion): 較小的資料型別(等號的右邊)自動晉升為較大的資料型別(等號的左邊)，預設上不需要做任何轉換

            型別轉換(Typecasting)： 較大型別的資料要轉換成較小型別的資料，須強制轉換

                ex: int x = 1;
                    double y = 2.2;
                    y = x + 1; // 晉升 output:3.2
                    x = (int)y + 1; // 型別轉換 output:3

*/






    }
}
