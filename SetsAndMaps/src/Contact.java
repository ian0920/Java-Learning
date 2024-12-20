import java.util.HashSet;
import java.util.Set;

public class Contact {

    private String name;
    private Set<String> emails = new HashSet<>();
    private Set<String> phones = new HashSet<>();

    public Contact(String name) {
        this(name,null);
    }

    public Contact(String name, String email) {
        this(name,email,0);
    }

    public Contact(String name, long phone) {
        this(name,null, phone);
    }

    public Contact(String name, String email, long phone){
        this.name = name;
        if(email != null){
            emails.add(email);
        }

        if(phone > 0 ){
            String p = String.valueOf(phone);
            p = "(%s)%s-%s".formatted(p.substring(0,3), p.substring(3,6), p.substring(6));
            phones.add(p);
        }

    }

    public String getName() {
        return name;
    }

    public String getLastFirst (){
        return name.substring(name.indexOf(" ")+1)+ "," + name.substring(0, name.indexOf(" "));

    }

    @Override
    public String toString() {
        return "%s: %s %s".formatted(name, emails, phones);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;
        return getName().equals(contact.getName());
    }

    @Override
    public int hashCode() {
        return 33 * getName().hashCode();
        // give it a multiplier to make different between Contact object and a String share the same name
        // Like Contact.name = "Mickey Mouse" and  String "Mickey Mouse"
    }

    public Contact mergeContactData (Contact contact){

        // Contact tim.mergeContactData(duplicate)
        // -> Contact newContact = new Contact(tim.name);
        // newContact.emails = new HashSet<>(tim.emails); create a new field
        // newContact.phones = new HashSet<>(tim.phones);
        // newContact.emails.addAll(duplicate.emails); put the previous email information into same object
        // newContact.phones.addAll(duplicate.phones); put the previous phone information into same object


        Contact newContact = new Contact(name); // the name of the instance that call this method
        newContact.emails = new HashSet<>(this.emails);
        newContact.phones = new HashSet<>(this.phones);
        newContact.emails.addAll(contact.emails);
        newContact.phones.addAll(contact.phones);


        return newContact;
    }

    public void addEmail (String companyName){

        String[] names = name.split(" ");
        String email = "%c%s@%s.com".formatted(name.charAt(0), names[names.length -1 ],
                companyName.replace(" ", "").toLowerCase());

        if (emails.contains(email)){
            System.out.println(name + " already has " + email);
        } else {
            emails.add(email);
            System.out.println( name + " now has email : " + email + " to the list.");
        }

    }

    public void replaceEmailIfExists (String oldEmail, String newEmail){

        if (emails.contains(oldEmail)){
            emails.remove(oldEmail);
            emails.add(newEmail);
            System.out.println(oldEmail + "has replaced to " + newEmail);

        } else {
            System.out.println("No email were found");
        }

    }

}
