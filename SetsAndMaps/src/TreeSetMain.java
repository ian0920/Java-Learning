import java.util.*;

public class TreeSetMain {

    public static void main(String[] args) {

        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");


        //NavigableSet<Contact> sorted = new TreeSet<>(phones);
        // the class pass to NavigableSet should implement Comparable
        Comparator<Contact> mySort = Comparator.comparing(Contact::getName);
        NavigableSet<Contact> sorted = new TreeSet<>(mySort);
        sorted.addAll(phones);
        sorted.forEach(System.out::println);

        System.out.println("-----------");
        NavigableSet<String> justName = new TreeSet<>();//String have a natural sort order, so we don't have to pass comparator here
        phones.forEach(c-> justName.add(c.getName()));
        System.out.println(justName);

        System.out.println("-----------");
        NavigableSet<Contact> fullSet = new TreeSet<>(sorted);
        fullSet.addAll(emails);
        fullSet.forEach(System.out::println);


        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.sort(mySort);
        System.out.println("-----------");
        fullList.forEach(System.out::println);

        Contact min = Collections.min(fullSet,fullSet.comparator());
        Contact max = Collections.max(fullSet,fullSet.comparator());

        Contact first = fullSet.first();
        Contact last = fullSet.last();

        System.out.println("-----------");
        System.out.printf("min = %s ,first = %s %n", min.getName(), first.getName());
        System.out.printf("max = %s ,last = %s %n", max.getName(), last.getName());
        System.out.println("-----------");

        System.out.println("min = "+ min + "first = "+ first);
        System.out.println("max = "+ max + "first = "+ last);
        System.out.println("-----------");

        NavigableSet<Contact> copiedSet = new TreeSet<>(fullSet);
        System.out.println("First element = " + copiedSet.pollFirst());
        System.out.println("Last element = " + copiedSet.pollLast());
        copiedSet.forEach(System.out::println);
        System.out.println("-----------");

        Contact daffy = new Contact("Daffy Duck");
        Contact daisy = new Contact("Daisy Duck");
        Contact snoopy = new Contact("Snoopy");
        Contact archie = new Contact("Archie");

        for (Contact c : List.of(daffy,daisy,last,archie)){

            System.out.printf("ceiling(%s) = %s %n", c.getName(), fullSet.ceiling(c)); // the element >= passing argument
            System.out.printf("higher(%s) = %s %n", c.getName(), fullSet.higher(c)); //// the element > passing argument

        }

        System.out.println("-----------");

        for (Contact c : List.of(daffy,daisy,first,archie)){

            System.out.printf("floor(%s) = %s %n", c.getName(), fullSet.floor(c)); // the element <= passing argument
            System.out.printf("lower(%s) = %s %n", c.getName(), fullSet.lower(c));// the element < passing argument

        }

        System.out.println("-----------");

        NavigableSet<Contact> descendingSet = fullSet.descendingSet();
        // any changes to the fullSet will reflect to this set and vice versa
        descendingSet.forEach(System.out::println);

        System.out.println("-----------");

        Contact lastContact = descendingSet.pollLast();
        System.out.println("Removed "+ lastContact);
        descendingSet.forEach(System.out::println);
        System.out.println("-----------");
        fullSet.forEach(System.out::println);
        System.out.println("-----------");

        Contact marion = new Contact("Maid Marion");
        var headSet = fullSet.headSet(marion);// the sets(all the element) < toElement
        // overloaded version: false by default means exclude the element. headSet.(element, true) : include the element
        headSet.forEach(System.out::println);
        System.out.println("-----------");

        var tailSet = fullSet.tailSet(marion); //the sets (all the element) >= fromElement
        // overloaded version: true by default means include the element. tailSet.(element, false) : exclude the element
        tailSet.forEach(System.out::println);
        System.out.println("-----------");

        Contact linus = new Contact("Linus Van Pelt"); // fromElement <= the sets (all the element) < toElement
        var subSet = fullSet.subSet(linus,  marion); // from element(inclusive), to element (exclusive)
        // overloaded version: subSet(from element, false (exclusive), to element , true(inclusive))
        subSet.forEach(System.out::println);
        System.out.println("-----------");


    }
}
