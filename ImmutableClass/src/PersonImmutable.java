import java.util.Arrays;

public class PersonImmutable {

    private final String name;
    private final String dob;
    private final PersonImmutable[] kids;

    public PersonImmutable(String name, String dob, PersonImmutable[] kids) {
        this.name = name;
        this.dob = dob;
        this.kids = kids == null ? null: Arrays.copyOf(kids, kids.length);
    }

    public PersonImmutable(String name, String dob) {
        this(name, dob, null);
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public PersonImmutable[] getKids() {
        return kids == null? null : Arrays.copyOf(kids,kids.length);
    }


    @Override
    public String toString() {

        String kidString = "n/a";
        if(kids != null){
            String [] names = new String[kids.length];
            for (int i = 0; i <kids.length; i++){
                names[i] = kids[i].name;
                kidString = String.join(", ", names);

            }
        }
        return name + ", dob = " + dob + ", kids = " + kidString;
    }
}
