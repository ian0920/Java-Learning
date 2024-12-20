public class Beverage extends ProductForSale{


    public Beverage(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetail() {
        System.out.println("Type = " + type + " " + description + " is " + price);

    }
}
