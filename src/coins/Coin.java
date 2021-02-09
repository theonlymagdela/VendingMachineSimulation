package coins;

public abstract class Coin {

    private final double weight;
    private final double size;
    private int quantity;
    private final String name;

    public Coin(double weight, double size, int quantity, String name) {
        this.weight = weight;
        this.size = size;
        this.quantity = quantity;
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public double getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "1x " + getName();
    }
}
