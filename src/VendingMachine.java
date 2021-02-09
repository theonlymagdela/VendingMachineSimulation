import coins.CashRegister;
import coins.Coin;
import coins.CoinValues;
import products.Inventory;
import products.Product;

public class VendingMachine {

    private final CashRegister cashRegister = new CashRegister();
    private final Inventory inventory  = new Inventory();
    private double totalValueOfCoinsAdded = 0.0;

    public VendingMachine() {
    }

    public Inventory getInventory() {
        return inventory;
    }

    public CashRegister getCashRegister() {
        return cashRegister;
    }

    public void setTotal(double totalCoinsAdded) {
        this.totalValueOfCoinsAdded = totalCoinsAdded;
    }

    public Product selectProduct(String productName) {
        for(Product product: inventory.getProducts()) {
            if(product.getName().equals(productName)) {
                if(product.getQuantity() >= 1) {
                    product.setQuantity(product.getQuantity() - 1);
                    if(!exactChange(product)) {
                        System.out.println("EXACT CHANGE ONLY");
                    }
                } else {
                    System.out.println("SOLD OUT");
                }
                return product;
            }
        }
        return null;
    }

    public void acceptCoin(String name, double price) {
        if(isQuarter(cashRegister.getByName(name))) {
            totalValueOfCoinsAdded = totalValueOfCoinsAdded + 0.25;
            cashRegister.addQuantity(name);
            stillToPay(price);
        } else if (isDime(cashRegister.getByName(name))) {
            totalValueOfCoinsAdded = totalValueOfCoinsAdded + 0.10;
            cashRegister.addQuantity(name);
            stillToPay(price);
        } else if (isNickel(cashRegister.getByName(name))) {
            totalValueOfCoinsAdded = totalValueOfCoinsAdded + 0.05;
            cashRegister.addQuantity(name);
            stillToPay(price);
        }
    }

    public void stillToPay(double price) {
        double total = price - totalValueOfCoinsAdded;

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

    public void giveChange(double total) {

        if(cashRegister.getCoins() != null) {
            if (total <= -0.24 && (cashRegister.howManyCoinsByName(CoinValues.QUARTER.getName()) >= 1)) {
                System.out.println("Giving back one quarter");
                cashRegister.subtractQuantity(CoinValues.QUARTER.getName());
                giveChange(total + CoinValues.QUARTER.getValue());
            } else if (total <= -0.09  && (cashRegister.howManyCoinsByName(CoinValues.DIME.getName()) >= 1)) {
                System.out.println("Giving back one dime");
                cashRegister.subtractQuantity(CoinValues.DIME.getName());
                giveChange(total + CoinValues.DIME.getValue());
            } else if (total <= -0.04 && (cashRegister.howManyCoinsByName(CoinValues.NICKEL.getName()) >= 1)) {
                System.out.println("Giving back one nickel");
                cashRegister.subtractQuantity(CoinValues.NICKEL.getName());
                giveChange(total + CoinValues.NICKEL.getValue());
            } else if (total <= -0.04 && (cashRegister.howManyCoinsByName(CoinValues.NICKEL.getName()) < 1)) {
                System.out.println("No appropriate coins in register, sorry!");
            } else {
                System.out.println("Thank you for shopping with us!");
            }
        }
    }

    public boolean exactChange(Product product) {
        double price = 0 - product.getPrice();
        double coinValue = 0;
        double total = price - coinValue;

        int qnQuarter = cashRegister.howManyCoinsByName(CoinValues.QUARTER.getName());
        int qnDime = cashRegister.howManyCoinsByName(CoinValues.DIME.getName());
        int qnNickel = cashRegister.howManyCoinsByName(CoinValues.NICKEL.getName());

        while(total < 0) {
            if (total <= -0.24 && (qnQuarter >= 1)) {
                total = total - CoinValues.QUARTER.getValue();
                qnQuarter = qnQuarter -1;
            } else if (total <= -0.09  && (qnDime >= 1)) {
                total = total - CoinValues.DIME.getValue();
                qnDime = qnDime -1;
            } else if (total <= -0.04 && (qnNickel >= 1)) {
                total = total - CoinValues.DIME.getValue();
                qnNickel = qnNickel - 1;
            } else if (total <= -0.04 && (qnNickel <= 1)) {
                return false;
            }
        }
        return true;
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
