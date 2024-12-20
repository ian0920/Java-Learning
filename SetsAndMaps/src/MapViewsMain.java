import java.util.*;

public class MapViewsMain {

    public static void main(String[] args) {

        Map<String,Contact> contacts = new HashMap<>();
        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(),c));
        ContactData.getData("email").forEach(c -> contacts.put(c.getName(),c));

//        contacts.forEach((k,v) -> System.out.println("key = " + k + ", value = " + v));

        Set<String> keysView = contacts.keySet();
        System.out.println(keysView);

        Set<String> copyOfKeys = new TreeSet<>(keysView);// ordered sets
        System.out.println(copyOfKeys);

        if(contacts.containsKey("Linus Van Pelt")){

            System.out.println("Linus and I go way back, so of course I have info");
        }

        keysView.remove("Daffy Duck");
        System.out.println(keysView);
        contacts.forEach((k,v) -> System.out.println("key = " + k + ", value = " + v));


        copyOfKeys.remove("Linus Van Pelt");
        System.out.println(copyOfKeys);
        contacts.forEach((k,v) -> System.out.println("key = " + k + ", value = " + v));
        //still print Linus int the Map of contacts because copyOfKeys used the new construct to create the instance.
        //making it a new object and no related to original Map.


        keysView.retainAll(List.of("Linus Van Pelt", "Charlie Brown", "Robin Hood", "Mickey Mouse"));
        System.out.println(keysView);
        contacts.forEach((k,v) -> System.out.println("key = " + k + ", value = " + v));

        keysView.clear();
        System.out.println(contacts);

//        keysView.add("Daffy Duck");
//        this code compiled but causing UnsupportedOperationException.
//        because the set return from ketSet method doesn't support add or addAll operation.

        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(), c));

        System.out.println(keysView);

        var values = contacts.values();
        values.forEach(System.out::println);

        values.retainAll(ContactData.getData("email"));
        System.out.println(keysView);
        contacts.forEach((k, v) -> System.out.println(v));


        System.out.println("--------------------------------");

        List<Contact> list = new ArrayList<>(values);
        list.sort(Comparator.comparing(Contact::getLastFirst));
        list.forEach(c -> System.out.println(c.getLastFirst() + " : " + c));

        System.out.println("--------------------------------");

        Contact first = list.get(0);
        contacts.put(first.getLastFirst(), first);
        values.forEach(System.out::println);
        keysView.forEach(System.out::println);

        HashSet<Contact> set = new HashSet<>(values);
        set.forEach(System.out::println);
        if(set.size()<keysView.size()){
            System.out.println("Duplicate values in the map");
        }

        System.out.println("--------------------------------");

        var nodeSet = contacts.entrySet();
        // type Set<Entry<String,Contact>> , Entry is a nested class of Map
        for (var node : nodeSet){
            System.out.println(node.getClass().getName());
            if (!node.getKey().equals(node.getValue().getName())){
                System.out.println(node.getClass().getName());
                System.out.println("key doesn't match the name : " + node.getKey() +  " with the value : " + node.getValue());
            }
        }



    }
}
