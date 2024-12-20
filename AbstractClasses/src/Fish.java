public class Fish extends Animal{


    public Fish(String type, String size, int weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if (speed.equals("slow")){
            System.out.print( getExplicitType() + " lazily swimming");
        } else {
            System.out.print( getExplicitType() + " darting frantically");
        }
    }

    @Override
    public void makeNoise() {

        if (type == "Goldfish"){
            System.out.print("swish! ");
        } else {
            System.out.print("splash! ");
        }

    }
}
