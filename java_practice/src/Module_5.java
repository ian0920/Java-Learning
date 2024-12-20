public class Module_5 {

    public static void main(String[] args) {

/*
        變數的特性及命名規則：

            - 每個變數都有佔記憶體，可以佔存資料以利後續使用
            - 一個變數/常數只能儲存一個值

            1. 第一個字不能是數字
            2. case-sensitive
            3. 不能是keyword(保留字)  * goto & const 也為關鍵字 (其他語言常用)

        官方命名約定：

            - Variable (變數) & Method (方法)： 第一個單字小寫，後續單字開頭大寫
            - Class (類別)： 單字開頭大寫

        變數宣告 (Variable Declaration)

            宣告方式：
            <資料型別> <變數名稱>   ex: int i; int j, k; (同類型的變數可一起宣告)

            指定初始值：
            int i; i = 1; *指定的變數需要是區域變數(Local Variables)才可以

            宣告同時賦予初始值：
            <資料型別> <變數名稱> = <初始值>;      ex: int i = 1;

            錯誤示範：

                1. 重複宣告
                int num1 = 0; int = 100; 錯誤！

                2. 個別宣告
                int num1, num2, num3 = 0; 只有num3被賦予值。 變數宣告需要個別宣告！


        變數的種類

            1. 區域變數(Local variables)
                - 宣告在方法 (Method) or 程式區塊(block)內    ex: { code }
                - 只能在被宣告的方法區域內使用
                - 又稱automatic, temporary或stack variables

            2. 實體變數(Instance variables)
                - 宣告在類別(class)內、方法外
                - 可被類別(class)內任何非 static method 使用
                - 又稱member variables(成員變數)、attribute variables(屬性變數)

            3. 類別變數(Static variables)
                - 加上static 修飾的變數
                - 也稱靜態變數


        常數宣告及命名規則：

            1. 通常全部大寫，單字之間以下底線分開    ex: MY_NAME
            2. 宣告方式： 在宣告時加上 final keyword  ex：  final <資料型別> <變數名稱>  final double PI = 3.14;
            3. 常數在初始值化後，就不可再更變


 */
    }
}
