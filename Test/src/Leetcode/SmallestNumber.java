package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class SmallestNumber {

    public static void main(String[] args) {

        System.out.println(smallestNumber(-9723417510000235l));
    }


    public static long smallestNumber(long num) {

        if (num == 0){
            return 0;
        }

        String[] array = new String[String.valueOf(num).length()];

        for(int i = 0; i < array.length; i++){
            array[i] = String.valueOf(String.valueOf(num).charAt(i));
        }


        if(array[0].equals("-")){


            StringBuilder result = new StringBuilder();
            Arrays.stream(array).sorted().skip(1).sorted(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2) * -1;
                }
            }).forEach(s -> result.append(s));



            return Long.valueOf(result.toString()) * -1;
        } else{

            Arrays.sort(array);
            int index = 0;
            int count = 0;

            while(array[count].equals("0") && !array[count].equals("-")){
                index = count;
                count++;
            }



            String temp = "";
            if(index != 0){
                array[0] = array[index + 1];
                array[index + 1] = "0";
            } else if (array[0].equals("0")) {
                temp = array[1];
                array[0] = temp;
                array[1] = "0";
            }



            StringBuilder result = new StringBuilder();

            for (int i = 0; i < array.length; i++){
                result.append(array[i]);
            }

            return Long.valueOf(result.toString());

        }

    }

}
