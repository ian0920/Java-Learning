public abstract class ProductForSale {

    public String type;
    public double price;
    public String description;

    double getSalesPrice (int quantity){

        return quantity*price;
    }

    void printPricedItem (int quantity){


    }

    abstract void showDetails();
}
