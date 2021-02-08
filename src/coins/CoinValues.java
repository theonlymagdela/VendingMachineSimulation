package coins;

public enum CoinValues {

    DIME(2.28, 0.705),
    NICKEL(5.01, 0.835),
    QUARTER(5.67, 0.955);

    private final double weight;
    private final double size;

    CoinValues(double weight, double size) {
        this.weight = weight;
        this.size = size;
    }

    public double getWeight() {
        return weight;
    }

    public double getSize() {
        return size;
    }
}
