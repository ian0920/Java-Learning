public class InventoryItem {

    private Product product;
    private double Price;
    private int qtyTotal;
    private int qtyReserved;
    private int qtyReOrder;
    private int qtyLow;

    public InventoryItem(Product product, double Price, int qtyTotal, int qtyLow) {
        this.product = product;
        this.Price = Price;
        this.qtyTotal = qtyTotal;
        this.qtyLow = qtyLow;
        this.qtyReOrder = qtyTotal;
    }

    public Product getProduct() {
        return product;
    }

    public double getPrice() {
        return Price;
    }

    public boolean reserveItem (int qty){

        if( (qtyTotal-qtyReserved) >= qty ){
            qtyReserved += qty;
            return true;
        }
        return false;
    }

    public void releaseItem (int qty){
        qtyReserved -= qty;

    }

    public boolean sellItem ( int qty ){

        if( qtyTotal >= qty ){
            qtyTotal -= qty;
            qtyReserved -= qty;
            if( qtyTotal <= qtyLow ){
                placeInventoryOrder();

            }
            return true;
        }
        return false;

    }

    private void placeInventoryOrder (){
        System.out.printf("Ordering qty %d : %s %n", qtyReOrder, product);


    }

    @Override
    public String toString() {
        return "%s, $%.2f :[%04d,% 2d]".formatted(product, Price, qtyTotal, qtyReserved);
    }
}