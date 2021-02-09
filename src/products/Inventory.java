package products;

import coins.Coin;

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

    public void subtractQuantity(String name) {
        for(Product product: products) {
            if(product.getName().equals(name)) {
                product.setQuantity(product.getQuantity() - 1);
            }
        }
    }

    public void printInventory() {
        for(Product product: products) {
            System.out.println(product);
        }
    }
}
