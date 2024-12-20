public class Horse extends Mammal{

    public Horse (String type, String size, int weight){
        super(type, size, weight);
    }

    // move() method is implemented on the superclass 'Mammal' so Horse don't have to implement it
    // Horse can directly use the method or override it as its requirement

    @Override
    public void makeNoise() {

    }

    @Override
    public void shedHair() {

        System.out.println(getExplicitType() + "shed in the spring");

    }


}
