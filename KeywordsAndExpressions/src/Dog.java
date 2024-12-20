public class Dog implements Print{

    private String name;
    public String type;

    @Override
    public void print() {
        System.out.println("woof" + " "+ type);
    }
}
