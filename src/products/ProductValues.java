package products;

public enum ProductValues {
    CANDY("CANDY"),
    CHIPS("CHIPS"),
    COKE("COKE");

    private final String name;

    ProductValues(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
