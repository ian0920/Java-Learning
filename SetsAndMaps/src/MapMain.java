import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMain {

    public static void main(String[] args) {

        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.forEach(System.out::println);
        System.out.println("-----------------------");

        Map<String , Contact> contacts = new HashMap<>();

        for(Contact c : fullList){
            contacts.put(c.getName(), c); // put() method will update the values if the key has been added.

        }

        contacts.forEach((K,V) -> System.out.println("Key = " + K + ", Value = " + V));
        System.out.println("-----------------------");

        System.out.println(contacts.get("Charlie Brown"));  // get(Key) return the Value

        System.out.println(contacts.get("Chuck Brown")); //return null

        Contact defaultContact = new Contact("Chuck Brown");
        System.out.println(contacts.getOrDefault("Chuck Brown",  defaultContact)); // return the default value as I passed
        System.out.println("-----------------------");

        contacts.clear();

        for (Contact c : fullList){
            Contact duplicates = contacts.put(c.getName(), c);
            // put() return null if the value isn't found in the map or return previous value associated with key.
            if (duplicates!= null){
//                System.out.println("duplicate = " + duplicates);
//                System.out.println("current = " + c);
                contacts.put(c.getName(), c.mergeContactData(duplicates));
            }

        }

        contacts.forEach((K,V) -> System.out.println("Key = " + K + ", Value = " + V));

        System.out.println("-----------------------");
        contacts.clear();

        for(Contact c : fullList){
            contacts.putIfAbsent(c.getName(), c);
            // return null for the first time the key mapped to value, else return the current value.
        }
        contacts.forEach((K,V) -> System.out.println("Key = " + K + ", Value = " + V));

        System.out.println("-----------------------");
        contacts.clear();

        for(Contact c : fullList){
            Contact duplicate = contacts.putIfAbsent(c.getName(), c);
            if(duplicate != null){
                contacts.put(c.getName(), c.mergeContactData(duplicate));
            }

        }
        contacts.forEach((K,V) -> System.out.println("Key = " + K + ", Value = " + V));

        System.out.println("-----------------------");
        contacts.clear();

        fullList.forEach( contact -> contacts.merge(contact.getName(), contact,
                (previous, current) ->{
                    System.out.println("prev: " + previous + " : current " + current);
                    Contact merged = previous.mergeContactData(current);
                    System.out.println("merged: " + merged);
                    return merged;
                }
                ));
        contacts.forEach((K,V) -> System.out.println("Key = " + K + ", Value = " + V));


        System.out.println("-----------------------");
        contacts.clear();

        fullList.forEach( contact -> contacts.merge(contact.getName(), contact,
                Contact::mergeContactData) );
                //(previous, current) -> previous.mergeContactData(current) replace with lambda expression


        contacts.forEach((K,V) -> System.out.println("Key = " + K + ", Value = " + V));

        System.out.println("----------compute()-------------");
        //compute()
        for(String contactName : new String [] {"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}){

            contacts.compute( contactName, (k, v) -> new Contact(k) );
        }
        contacts.forEach((k, v) -> System.out.println("Key = " + k + ", Value = " + v));


        System.out.println("-----------computeIfAbsent()------------");
        //computeIfAbsent()
        contacts.clear();

        fullList.forEach( contact -> contacts.merge(contact.getName(), contact,
                Contact::mergeContactData) );


        for(String contactName : new String [] {"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}){

            contacts.computeIfAbsent(contactName, Contact::new);
            //contacts.computeIfAbsent( contactName, k -> new Contact(k) ) replaced with lambda expression
        }
        contacts.forEach((k, v) -> System.out.println("Key = " + k + ", Value = " + v));

        System.out.println("------------computeIfPresent()-----------");
        //computeIfPresent()
        for(String contactName : new String [] {"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}){

            contacts.computeIfPresent(contactName, (k, v) -> {
                v.addEmail("Fun Place"); return v;  } );
        }
        contacts.forEach((k, v) -> System.out.println("Key = " + k + ", Value = " + v));

        System.out.println("-----------------------");

        contacts.replaceAll((k, v) -> {
            String newEmail = k.replaceAll(" ", "") + "@funplace.com";
            v.replaceEmailIfExists("DDuck@funplace.com", newEmail);
            return v;
        });

        contacts.forEach((k, v) -> System.out.println("Key = " + k + ", Value = " + v));

        System.out.println("-----------------------");

        Contact daisy = new Contact("Daisy Jane Duck", "daisyj@duck.com");
        Contact replacedContact = contacts.replace("Daisy Duck", daisy); // return the previous value
        System.out.println("daisy = " + daisy);
        System.out.println("replace contact = " + replacedContact);
        contacts.forEach((k,v) -> System.out.println("Key = " + k + ", Value = " + v));
        System.out.println("_____" + replacedContact);


        System.out.println("-----------------------");
        Contact updatedDaisy = replacedContact.mergeContactData(daisy);
        System.out.println("updatedDaisy = " + updatedDaisy );

        //boolean success = contacts.replace("Daisy Duck", replacedContact, updatedDaisy);
        // since replace method return the previous value, replacedContact return Daisy Duck: [DaisyDuck@funplace.com] []


        boolean success = contacts.replace("Daisy Duck", daisy, updatedDaisy);
        if(success){
            System.out.println("Successfully replaced element");
        }else {
            System.out.printf("Did not match on both key: %s and value: %s %n"
                    .formatted("Daisy Duck", replacedContact));
        }

        contacts.forEach((k,v) -> System.out.println("Key = " + k + ", Value = " + v));


        System.out.println("-----------------------");
        success = contacts.remove("Daisy Duck", updatedDaisy);

        if (success) {
            System.out.println("Successfully removed the element");
        } else {
            System.out.printf("Did not match on both key: %s and value: %s %n"
                    .formatted("Daisy Duck", updatedDaisy));
        }

        contacts.forEach((k,v) -> System.out.println("Key = " + k + ", Value = " + v));




    }

}
