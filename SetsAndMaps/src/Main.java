import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");

        printData("Phone List = ", phones);
        printData("Email List = ",emails );

        Set<Contact> emailContact = new HashSet<>(emails);
        Set<Contact> phoneContact = new HashSet<>(phones);

        printData("Phone Contact = ", phoneContact);
        printData("Email Contact = ", emailContact);

        int index = emails.indexOf(new Contact("Robin Hood"));
        Contact robinHood = emails.get(index);
        System.out.println("-----");
        System.out.println(robinHood);

        robinHood.addEmail("Sherwood Forest");
        robinHood.addEmail("Sherwood Forest");
        System.out.println(robinHood);
        robinHood.replaceEmailIfExists("RHood@sherwoodforest.com", "RHood@sherwoodforest.org");


        Set<Contact> unionAB = new HashSet<>();
        unionAB.addAll(emailContact);
        unionAB.addAll(phoneContact);
        printData("(A ∪ B) Union of emails(A) with phones (B)", unionAB);


        Set<Contact> intersectAB = new HashSet<>(emailContact);
        intersectAB.retainAll(phoneContact);
        printData("(A ∩ B) Intersect of emails(A) with phones (B)", intersectAB);
        //email set first in the set list, so the following added, and it will be ignored.
        //Robin Hood: [RHood@sherwoodforest.org, rhood@gmail.com] []
        //Mickey Mouse: [mckmouse@gmail.com] []
        //Minnie Mouse: [minnie@verizon.net] []

        Set<Contact> intersectBA = new HashSet<>(phoneContact);
        intersectBA.retainAll(emailContact);
        printData("(B ∩ A) Intersect of phones (B) with emails(A) ", intersectBA);


        Set<Contact> AMinusB = new HashSet<>(emailContact);
        AMinusB.removeAll(phoneContact);
        printData("(A - B) Difference of emails(A) minus phones (B)", AMinusB);

        Set<Contact> BMinusA = new HashSet<>(phoneContact);
        BMinusA.removeAll(emailContact);
        printData("(B - A) Difference of phones (B) minus emails(A)", BMinusA);

        Set<Contact> symmetricDifference = new HashSet<>(AMinusB);
        symmetricDifference.addAll(BMinusA);
        printData("Symmetric difference : phones and emails", symmetricDifference);


        Set<Contact> symmetricDifference1 = new HashSet<>(unionAB);
        symmetricDifference1.removeAll(intersectAB);
        printData("Symmetric difference : phones and emails", symmetricDifference1);
    }


    public static void printData (String header, Collection<Contact> contacts){

        System.out.println("--------------------------");
        System.out.println(header);
        System.out.println("--------------------------");
        contacts.forEach(System.out::println);

    }
}
