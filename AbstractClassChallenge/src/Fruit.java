public class Fruit extends ProductForSale{


    public Fruit(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetail() {
        System.out.println("Type = " + type + " " + description + " is " + price);

    }
}
