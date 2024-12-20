package module01_06;
/*
 * 此範例為關係運算子測試使用
 * 可自行更換變數的值進行比較結果
 */
public class TestRelationalOP {

	public static void main(String[] args) {
		int num1 = 5, num2 = 3;
		System.out.println(num1 < num2);  // false
		System.out.println(num1 <= num2); // false
		System.out.println(num1 == num2); // false
		System.out.println(num1 != num2); // true
		System.out.println(num1 >= num2); // true
		System.out.println(num1 > num2);  // true
	}

}
