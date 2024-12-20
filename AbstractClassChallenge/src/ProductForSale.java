public abstract class ProductForSale {

    protected String type;
    protected double price;
    protected String description;

    public ProductForSale(String type, double price, String description){
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public void printPricedItem (int qty){
        System.out.println(qty*price);
    }

    public double getSalePrice (int qty){
        return qty * price;
    }

    public abstract void showDetail();
}
