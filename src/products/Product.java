package products;

public abstract class Product {

    private final double price;
    private int quantity;
    private final String name;

    public Product(double price, int quantity, String name) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return quantity + "x " + name + " at " + price + " USD";
    }
}
