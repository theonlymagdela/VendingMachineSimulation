package coins;

public enum CoinValues {

    DIME(2.28, 0.705, 0.10, "DIME"),
    NICKEL(5.01, 0.835, 0.05, "NICKEL"),
    QUARTER(5.67, 0.955, 0.25, "QUARTER");

    private final double weight;
    private final double size;
    private final double value;
    private final String name;

    CoinValues(double weight, double size, double value, String name) {
        this.weight = weight;
        this.size = size;
        this.value = value;
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public double getSize() {
        return size;
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
