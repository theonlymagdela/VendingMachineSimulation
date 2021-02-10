import coins.CashRegister;
import coins.Coin;
import coins.CoinValues;
import products.Inventory;
import products.Product;

import java.math.BigDecimal;

public class VendingMachine {

    private final CashRegister cashRegister = new CashRegister();
    private final Inventory inventory  = new Inventory();
    private final CurrentSelect currentSelect = new CurrentSelect();
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
                    currentSelect.setProductName(productName);
                    if(!exactChange(product)) {
                        System.out.println("EXACT CHANGE ONLY");
                    }
                    return product;
                } else {
                    System.out.println("SOLD OUT");
                    return null;
                }
            }
            System.out.println("NOT IN INVENTORY");
            return null;
        }
        return null;
    }

    public boolean acceptCoin(String name, double price) {
        if(isQuarter(cashRegister.getByName(name))) {
            totalValueOfCoinsAdded = totalValueOfCoinsAdded + 0.25;
            currentSelect.addToList(name);
            System.out.println("ACCEPTED QUARTER");
            return stillToPay(price);
        } else if (isDime(cashRegister.getByName(name))) {
            totalValueOfCoinsAdded = totalValueOfCoinsAdded + 0.10;
            currentSelect.addToList(name);
            System.out.println("ACCEPTED DIME");
            return stillToPay(price);
        } else if (isNickel(cashRegister.getByName(name))) {
            totalValueOfCoinsAdded = totalValueOfCoinsAdded + 0.05;
            currentSelect.addToList(name);
            System.out.println("ACCEPTED NICKEL");
            return stillToPay(price);
        } else if (name.equals("break")) {
            returnCoins();
            return false;
        }
        return false;
    }

    public boolean stillToPay(double price) {
        double total = price - totalValueOfCoinsAdded;

        if (total > 0) {
            System.out.println("STILL TO PAY " + (String.format("%.2f", total)) + " USD");
            return true;
        } else if (total == 0) {
            System.out.println("THANK YOU FOR SHOPPING WITH US!");
            subtractFromProduct();
            addToCoins();
            setTotal(0.0);
            return false;
        } else {
            System.out.println("YOUR CHANGE IS " + String.format("%.2f", total));
            giveChange(total);
            setTotal(0.0);
            return false;
        }
    }

    public void giveChange(double total) {
        if(cashRegister.getCoins() != null) {
            if (total <= -0.24 && (cashRegister.howManyCoinsByName(CoinValues.QUARTER.getName()) >= 1)) {
                System.out.println("GIVING BACK ONE QUARTER");
                cashRegister.subtractQuantity(CoinValues.QUARTER.getName());
                giveChange(total + CoinValues.QUARTER.getValue());
            } else if (total <= -0.09  && (cashRegister.howManyCoinsByName(CoinValues.DIME.getName()) >= 1)) {
                System.out.println("GIVING BACK ONE DIME");
                cashRegister.subtractQuantity(CoinValues.DIME.getName());
                giveChange(total + CoinValues.DIME.getValue());
            } else if (total <= -0.04 && (cashRegister.howManyCoinsByName(CoinValues.NICKEL.getName()) >= 1)) {
                System.out.println("GIVING BACK ONE NICKEL");
                cashRegister.subtractQuantity(CoinValues.NICKEL.getName());
                giveChange(total + CoinValues.NICKEL.getValue());
            } else if (total <= -0.04 && (cashRegister.howManyCoinsByName(CoinValues.NICKEL.getName()) < 1)) {
                System.out.println("NO APPROPRIATE COINS IN REGISTER, SORRY!");
                returnCoins();
            } else {
                System.out.println("THANK YOU FOR SHOPPING WITH US");
                subtractFromProduct();
                addToCoins();
            }
        }
    }

    public boolean exactChange(Product product) {
        double total = 0 - product.getPrice();

        int qnQuarter = cashRegister.howManyCoinsByName(CoinValues.QUARTER.getName());
        int qnDime = cashRegister.howManyCoinsByName(CoinValues.DIME.getName());
        int qnNickel = cashRegister.howManyCoinsByName(CoinValues.NICKEL.getName());

        while(total < 0) {
            if (total <= -0.24 && (qnQuarter >= 1)) {
                total = total + CoinValues.QUARTER.getValue();
                qnQuarter = qnQuarter -1;
            } else if (total <= -0.09  && (qnDime >= 1)) {
                total = total + CoinValues.DIME.getValue();
                qnDime = qnDime -1;
            } else if (total <= -0.04 && (qnNickel >= 1)) {
                total = total + CoinValues.NICKEL.getValue();
                qnNickel = qnNickel - 1;
            } else if (total <= 0.00001) {
                return true;
            } else if (total <= -0.04 && (qnNickel < 1)) {
                return false;
            }
        }
        return true;
    }

    public void returnCoins() {
        currentSelect.printTheList();
        currentSelect.emptyList();
        currentSelect.setProductName(null);
        setTotal(0.0);
    }

    public void addToCoins() {
        for(String coin: currentSelect.getListOfCoins()) {
            cashRegister.addQuantity(coin);
        }
        currentSelect.emptyList();
    }

    public void subtractFromProduct() {
        inventory.subtractQuantity(currentSelect.getProductName());
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