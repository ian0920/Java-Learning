public class Hello {

    public static void main(String[] args) {
        System.out.println("Hello,Tim");


        boolean isAlien = false;
        if (!isAlien) {
            System.out.println("I don't believe you!");
        }

        int topScore = 11;
        int secondScore = 60;
        if (topScore > secondScore || topScore < 100) {
            System.out.println("Well done!");
        }

        String loveFood = "Ramen";
        boolean andYou = loveFood =="Ramen"? true : false;

        if(andYou){
            System.out.println("So do I!");
        }

        double firstDouble = 20.00d;
        double secondDouble = 80.00d;
        double remainder = ((firstDouble + secondDouble)*100) % 40d;

        boolean x = remainder == 0 ? true : false;
        System.out.println(x);

        if(!x){
            System.out.println("got some remainder");
        }





    }

}
