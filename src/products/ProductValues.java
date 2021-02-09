package products;

public enum ProductValues {
    CANDY("candy"),
    CHIPS("chips"),
    COKE("coke");

    private final String name;

    ProductValues(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
