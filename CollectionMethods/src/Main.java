import java.util.*;

public class Main {

    public static void main(String[] args) {



        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(cardArray, aceOfHearts);


        Card.printDeck(Arrays.asList(cardArray), "Ace of Heart", 1);

        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards, aceOfHearts);
        // replace every element that pass to the method, however, unlike array, if the element is empty, it shows null.
        // Arraylist stay empty until the element pass in. So even called Collections.fill(), the list just stay empty.
        System.out.println(cards);;
        System.out.println("cards.size() = " + cards.size());

        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        //creates a new list, with the number of elements specified as the first argument.
        Card.printDeck(acesOfHearts, "Aces of Hearts", 1);

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs, "Kings of Clubs", 1);


        Collections.addAll(cards,cardArray); //(List<Card>, Card[])
        Collections.addAll(cards,cardArray);

        //cards.addAll(cardArray); don't work!!! //cards.addAll(Arrays.asList(cardArray));
        Card.printDeck(cards,"Card collection with aces add", 2);


        Collections.copy(cards,kingsOfClubs);  //Collections(destination, element)
        Card.printDeck(cards,"Card collection with kings add", 2);

        //------------------------------- video.200

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Collections.shuffle(deck);
        Card.printDeck(deck,"shuffled deck", 4);

        Collections.reverse(deck);
        Card.printDeck(deck,"reversed deck", 4);


        var sortAlgorithm = Comparator.comparing(Card::rank) //Comparator.comparing((Card s) -> s.rank())
                .thenComparing(Card::suit);

        Collections.sort(deck,sortAlgorithm);
        Card.printDeck(deck,"sorted by collection", 13);
        deck.sort(sortAlgorithm);
        Card.printDeck(deck,"sorted by list", 13);

        Collections.reverse(deck);

        List<Card> kings = new ArrayList<>(deck.subList(4,8));
        Card.printDeck(kings, "Kings in deck", 1);

        List<Card> tens = new ArrayList<>(deck.subList(16,20));
        tens.addAll(kings.subList(0,1));
        System.out.println("new tens = " + tens);

        int subListIndex = Collections.indexOfSubList(deck, tens);
        System.out.println("sublist index for tens = " + subListIndex);

        boolean disjoint = Collections.disjoint(tens,kings);
        System.out.println("result of disjoint = " + disjoint);

        deck.sort(sortAlgorithm);
        Card tenOfHeart = Card.getNumericCard(Card.Suit.HEART, 10);
        int foundIndex = Collections.binarySearch(deck,tenOfHeart,sortAlgorithm);
        System.out.println("Found index = " + foundIndex);
        System.out.println(deck.get(foundIndex));
        int index = deck.indexOf(tenOfHeart);
        System.out.println(index);
        var index2 = deck.contains(tenOfHeart);


        Card tenOfClub = Card.getNumericCard(Card.Suit.CLUB,10);
        Collections.replaceAll(deck,tenOfClub,tenOfHeart);
        // the result is ignored because it returns boolean value and true means the element has been replaced
        Card.printDeck(deck.subList(32,36),"ten of row", 1);

        Collections.replaceAll(deck,tenOfHeart,tenOfClub);
        Card.printDeck(deck.subList(32,36),"ten of row", 1);

        if (Collections.replaceAll(deck,tenOfHeart,tenOfClub)){

            System.out.println("tens of heart replaced with tens of club");
        }else{

            System.out.println("No tens of heart were found");
        }


        System.out.println("tens of clubs card = " +
                Collections.frequency(deck, tenOfClub));


        System.out.println("The best card = " + Collections.max(deck,sortAlgorithm));
        System.out.println("The worst card = " + Collections.min(deck,sortAlgorithm));

        var sortBySuit = Comparator.comparing(Card::suit).thenComparing(Card::rank);
        deck.sort(sortBySuit);

        Card.printDeck(deck,"sorted by suit, rank", 4);

        List<Card> copied = new ArrayList<>(deck.subList(0,13));
        Collections.rotate(copied,2);


        System.out.println("UnRotated" + deck.subList(0,13));
        System.out.println("Rotated" + 2 + " : " + copied);

        copied = new ArrayList<>(deck.subList(0,13));
        Collections.rotate(copied,-2);

        System.out.println("UnRotated" + deck.subList(0,13));
        System.out.println("Rotated" + -2 + " : " + copied);

        copied = new ArrayList<>(deck.subList(0,13));
        for(int i = 0; i<copied.size()/2; i++){
            Collections.swap(copied, i , copied.size()-1-i);
        }
        System.out.println("Manual reverse : " + copied);

        copied = new ArrayList<>(deck.subList(0,13));
        Collections.reverse(copied);
        System.out.println("Collection method reverse : " + copied);




    }

}
