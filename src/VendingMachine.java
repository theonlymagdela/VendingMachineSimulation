import coins.CashRegister;
import coins.Coin;
import products.Inventory;
import products.Product;

public class VendingMachine {

    private final CashRegister cashRegister = new CashRegister();
    private final Inventory inventory  = new Inventory();
    private double totalCoinsAdded = 0.0;

    public VendingMachine() {
    }

    public Inventory getInventory() {
        return inventory;
    }

    public CashRegister getCashRegister() {
        return cashRegister;
    }

    public void setTotal(double totalCoinsAdded) {
        this.totalCoinsAdded = totalCoinsAdded;
    }

    public Product pickProduct(String productName) {
        for(Product product: inventory.getProducts()) {
            if(product.getName().equals(productName)) {
                product.setQuantity(product.getQuantity() - 1);
                return product;
            }
        }
        return null;
    }

    public void acceptCoin(Coin coin) {
        if(isQuarter(coin)) {
            totalCoinsAdded = totalCoinsAdded + 0.25;
            cashRegister.add(coin);
        } else if (isDime(coin)) {
            totalCoinsAdded = totalCoinsAdded + 0.10;
            cashRegister.add(coin);
        } else if (isNickel(coin)) {
            totalCoinsAdded = totalCoinsAdded + 0.05;
            cashRegister.add(coin);
        }
    }

    public void stillToPay(double price) {
        double total = price - totalCoinsAdded;

        if (total > 0) {
            System.out.println("Still to pay " + (String.format("%.2f", total)) + " USD");
        } else if (total == 0) {
            System.out.println("Thank you for shopping with us!");
            setTotal(0.0);
        } else {
            System.out.println("Your change is " + String.format("%.2f", total));
            giveChange(total);
            setTotal(0.0);
        }
    }

    public double giveChange(double total) {
        double NickelValue = 0.05;
        double DimeValue = 0.10;
        double QuarterValue = 0.25;

        if(cashRegister.getCoins() != null) {
            if (total <= -0.24 && (cashRegister.howManyCoinsByName("quarter") >= 1)) {
                System.out.println("Giving back one quarter");
                cashRegister.removeByName("quarter");
                return giveChange(total + QuarterValue);
            } else if (total <= -0.09  && (cashRegister.howManyCoinsByName("dime") >= 1)) {
                System.out.println("Giving back one dime");
                cashRegister.removeByName("dime");
                return giveChange(total + DimeValue);
            } else if (total <= -0.04 && (cashRegister.howManyCoinsByName("nickel") >= 1)) {
                System.out.println("Giving back one nickel");
                cashRegister.removeByName("nickel");
                return giveChange(total + NickelValue);
            } else {
                return 0.0;
            }
        }
        System.out.println("Not enough coins! Sorry.");
        return 0.0;
    }

    public boolean isQuarter(Coin coin) {
        return ((coin.getWeight() == 5.67) && (coin.getSize() == 0.955));
    }

    public boolean isDime(Coin coin) {
        return ((coin.getWeight() == 2.28) && (coin.getSize() == 0.705));
    }

    public boolean isNickel(Coin coin) {
        return ((coin.getWeight() == 5.01) && (coin.getSize() == 0.835));
    }
}
