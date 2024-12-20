
import java.util.ArrayList;
import java.util.List;

public record Card (Suit suit, String face, int rank) {

    public enum Suit{
        CLUB, DIAMOND, HEART, SPADE;

        public char getImage(){

            //char[] s = new char[]{9827, 9830, 9829, 9824};

            return (new char[]{9827, 9830, 9829, 9824})[this.ordinal()];
            // return s[this.ordinal()]; ordinal() return  its position in the enum declaration
        }
    }

    @Override
    public String toString() {

        int index = face.equals("10")? 2:1;
        String faceString = face.substring(0,index);// if it's FaceCard substring it to first letter J for Jack etc..
        return "%s%c(%d)".formatted(faceString,suit.getImage(),rank);

    }

    public static Card getNumericCard (Suit suit, int cardNumber){

        if(1<cardNumber && cardNumber<11){
            return new Card(suit, String.valueOf(cardNumber), cardNumber-2);
            
        }
        System.out.println("Invalid Numeric Card Selected");
        return null;

    }

    public static Card getFaceCard (Suit suit, char abbrev){

        int index = "JQKA".indexOf(abbrev);
        if(index>-1){
            return new Card(suit, ""+abbrev, index+9);

        }
        System.out.println("Invalid Face Card Selected");
        return null;

    }

    public static List<Card> getStandardDeck(){

        List<Card> deck = new ArrayList<>(52);

        for(Suit s : Suit.values()){

            for (int i= 2; i<11; i++){
                deck.add(getNumericCard(s,i));
            }
            for (char c : new char[]{'J','Q','K','A'}){
                deck.add(getFaceCard(s,c));
            }
        }
        return deck;
    }

    public static void printDeck(List<Card> deck){

        printDeck(deck, "Current Deck", 4);
    }

    public static void printDeck (List<Card> deck, String description, int row){

        System.out.println("-------------------------------");
        if(description != null){
            System.out.println(description);
        }

        int cardsInRow = deck.size() / row;
        for (int i = 0; i<row ; i++){
            int startIndex = i*cardsInRow;
            int endIndex = startIndex+cardsInRow;
            deck.subList(startIndex,endIndex).forEach(c-> System.out.print(c+" "));
            System.out.println();
        }


    }


}
