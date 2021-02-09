package products;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private final List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {

        return products;
    }

    public void add(Product product) {
        products.add(product);
    }

    public void printInventory() {
        for(Product product: products) {
            System.out.println(product);
        }
    }
}
