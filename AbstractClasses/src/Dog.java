public class Dog extends Mammal{


    public Dog(String type, String size, int weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if (speed.equals("slow")){
            System.out.print( getExplicitType() + " walking");
        } else {
            System.out.print( getExplicitType() + " running");
        }
    }

    @Override
    public void shedHair() {
        System.out.println(getExplicitType() + "shed hair all the time");
    }

    @Override
    public void makeNoise() {

        if (type == "Wolf"){
            System.out.print("Howling! ");
        } else {
            System.out.print("Woof! ");
        }

    }
}
