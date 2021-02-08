package products;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private final List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        products.add(new Coke(20));
        products.add(new Candy(20));
        products.add(new Chips(20));

        return products;
    }
}
