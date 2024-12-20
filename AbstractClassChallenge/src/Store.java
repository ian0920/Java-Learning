import java.util.ArrayList;
import java.util.List;

public class Store {

    public static void main(String[] args) {


    }

    private static void addItemToOrder (int qty, ProductForSale product){

        List<OrderItem> list = new ArrayList<>();
        list.add(new OrderItem(qty, product));


    }

    private static void printOrder(){

    }
}
