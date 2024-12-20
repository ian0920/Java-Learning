public class Main {

    public static void main(String[] args) {

        String helloWorld = "%s %s".formatted("Hello", "World");
        String helloWorld2 = String.format("%s %s", "Hello", "World");
        System.out.println("Using String formatted = " + helloWorld);
        System.out.println("Using String format = " + helloWorld2);

        String helloWorld3 = Main.format("%s %s", "Hello", "World");
        System.out.println("Using Main format = " + helloWorld3);

        String testString = "Anyone can learn abc's, 123's, and any regular expression";
        String replacement = "(-)";

        String [] patterns = {
                "abc",
                "123",
                "A"
        };

        for (String pattern : patterns){
            String output = testString.replaceFirst(pattern, replacement);
            System.out.println("pattern: " + pattern + " => " + output );
        }


        String str = "";
        z:
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 2; y++) {
                if ( x == 1) break;
                if ( y == 2) break z;

                str = str + x + y;
            }
        }
        System.out.println(str);






    }

    private static String format (String regexp, String... args){

       int index= 0;
       while(regexp.matches(".*%s.*")){
           //regular expression otherwise, matches() return values as long as it matches with whole Strings
           //contains() as long as the String contain it.

           regexp = regexp.replaceFirst("%s", args[index]);
           index++;

       }
       return regexp;
    }
}
