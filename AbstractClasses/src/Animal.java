abstract class Mammal extends Animal{

    public Mammal(String type, String size, int weight) {
        super(type, size, weight);
    }

    @Override
    public void move (String speed){
        System.out.print(getExplicitType() + " ");
        System.out.print( speed.equals("slow")? "walk" : "run");
    }

    public abstract void shedHair ();

    // An abstract class can extends another abstract class
    // you can implement all, some of or none of the abstract methods
    // includes additional abstract methods and force subclasses to implement both Animal's and Mammal's methods
}


public abstract class Animal {

    protected String type;
    private String size;
    private int weight;

    public Animal (String type, String size, int weight){
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public abstract void move (String speed);
    public abstract void makeNoise ();

    public final String getExplicitType () {
        return getClass().getSimpleName() + "(" + type+ ")";
    }
}
