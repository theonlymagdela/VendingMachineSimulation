import coins.*;
import products.*;

public class Counter {

    public static void main(String[] args) {

        VendingMachine vendingMachine = new VendingMachine();

        var inventory = vendingMachine.getInventory();
        var cashRegister = vendingMachine.getCashRegister();

        System.out.println("<==============================>");
        System.out.println("Little machine around a corner");

        inventory.add(new Coke(2));
        inventory.add(new Candy(8));
        inventory.add(new Chips(3));

        System.out.println("<==============================>");
        System.out.println("Currently on shelves:");
        for(Product product: inventory.getProducts()) {
            System.out.println(product);
        }
        System.out.println("<==============================>");

        System.out.println("Moneys in register:");

        cashRegister.add(new Nickel(CoinValues.NICKEL.getWeight(), CoinValues.NICKEL.getSize(), 0));
        cashRegister.add(new Dime(CoinValues.DIME.getWeight(), CoinValues.DIME.getSize(), 0));
        cashRegister.add(new Quarter(CoinValues.QUARTER.getWeight(), CoinValues.QUARTER.getSize(), 0));

        System.out.println("Total coins: " + cashRegister.howManyCoinsTotal());
        System.out.println("<==============================>");

        System.out.println("SELECT PRODUCT");
        Product candy = vendingMachine.selectProduct(ProductValues.CANDY.getName());
        System.out.println(candy.getName() + " for " + candy.getPrice() + " USD was chosen");
        System.out.println("INSERT COINS");

        vendingMachine.acceptCoin(CoinValues.NICKEL.getName(), candy.getPrice());
        vendingMachine.acceptCoin(CoinValues.DIME.getName(), candy.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), candy.getPrice());
        vendingMachine.acceptCoin(CoinValues.DIME.getName(), candy.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), candy.getPrice());

        System.out.println("<===============================>");
        System.out.println("Currently on shelves:");
        inventory.printInventory();
        System.out.println("<===============================>");

        System.out.println("SELECT PRODUCT");
        Product coke = vendingMachine.selectProduct(ProductValues.COKE.getName());
        System.out.println(coke.getName() + " for " + coke.getPrice() + " USD was chosen");
        System.out.println("INSERT COINS");

        vendingMachine.acceptCoin(CoinValues.DIME.getName(), coke.getPrice());
        vendingMachine.acceptCoin(CoinValues.DIME.getName(), coke.getPrice());
        vendingMachine.acceptCoin(CoinValues.DIME.getName(), coke.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), coke.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), coke.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), coke.getPrice());

        System.out.println("<===============================>");
        System.out.println("Currently on shelves:");
        inventory.printInventory();
        System.out.println("<===============================>");

        System.out.println("SELECT PRODUCT");
        Product secondCoke = vendingMachine.selectProduct(ProductValues.COKE.getName());
        System.out.println(secondCoke.getName() + " for " + secondCoke.getPrice() + " USD was chosen");
        System.out.println("INSERT COINS");

        vendingMachine.acceptCoin(CoinValues.DIME.getName(), secondCoke.getPrice());
        vendingMachine.acceptCoin(CoinValues.DIME.getName(), secondCoke.getPrice());
        vendingMachine.acceptCoin(CoinValues.DIME.getName(), secondCoke.getPrice());
        vendingMachine.acceptCoin(CoinValues.NICKEL.getName(), secondCoke.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), secondCoke.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), secondCoke.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), secondCoke.getPrice());

        System.out.println("<===============================>");
        System.out.println("Currently on shelves:");
        inventory.printInventory();
        System.out.println("<===============================>");

        System.out.println("SELECT PRODUCT");
        Product chips = vendingMachine.selectProduct(ProductValues.CHIPS.getName());
        System.out.println(chips.getName() + " for " + chips.getPrice() + " USD was chosen");
        System.out.println("INSERT COINS");

        vendingMachine.acceptCoin(CoinValues.NICKEL.getName(), chips.getPrice());
        vendingMachine.acceptCoin(CoinValues.NICKEL.getName(), chips.getPrice());
        vendingMachine.acceptCoin(CoinValues.NICKEL.getName(), chips.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), chips.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), chips.getPrice());

        System.out.println("<===============================>");
        System.out.println("Currently on shelves:");
        inventory.printInventory();
        System.out.println("<===============================>");

        System.out.println("SELECT PRODUCT");
        vendingMachine.selectProduct(ProductValues.COKE.getName());
        System.out.println("SELECT PRODUCT");
        Product secondChips = vendingMachine.selectProduct(ProductValues.CHIPS.getName());
        System.out.println(secondChips.getName() + " for " + secondChips.getPrice() + " USD was chosen");
        System.out.println("INSERT COINS");
        vendingMachine.acceptCoin(CoinValues.NICKEL.getName(), chips.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), chips.getPrice());
        vendingMachine.acceptCoin(CoinValues.NICKEL.getName(), chips.getPrice());
        vendingMachine.acceptCoin(CoinValues.NICKEL.getName(), chips.getPrice());
        vendingMachine.acceptCoin(CoinValues.NICKEL.getName(), chips.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), chips.getPrice());
    }
}
