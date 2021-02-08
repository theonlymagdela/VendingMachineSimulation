package coins;

public abstract class Coin {

    private final double weight;
    private final double size;
    private final String name;

    public Coin(double weight, double size, String name) {
        this.weight = weight;
        this.size = size;
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

    @Override
    public String toString() {
        return "1x " + getName();
    }
}
