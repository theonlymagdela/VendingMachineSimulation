import coins.*;
import products.*;

public class Counter {

    public static void main(String[] args) {

        VendingMachine vendingMachine = new VendingMachine();

        var inventory = vendingMachine.getInventory();
        var cashRegister = vendingMachine.getCashRegister();

        System.out.println("<==============================>");
        System.out.println("LITTLE MACHINE AROUND A CORNER");

        inventory.add(new Coke(2));
        inventory.add(new Candy(8));
        inventory.add(new Chips(3));

        System.out.println("<==============================>");
        System.out.println("ON SHELVES:");
        for(Product product: inventory.getProducts()) {
            System.out.println(product);
        }
        System.out.println("<==============================>");

        cashRegister.add(new Nickel(CoinValues.NICKEL.getWeight(), CoinValues.NICKEL.getSize(), 6));
        cashRegister.add(new Dime(CoinValues.DIME.getWeight(), CoinValues.DIME.getSize(), 4));
        cashRegister.add(new Quarter(CoinValues.QUARTER.getWeight(), CoinValues.QUARTER.getSize(), 2));
        cashRegister.printRegister();
        System.out.println("<==============================>");

        System.out.println("SELECT PRODUCT");
        Product candy = vendingMachine.selectProduct(ProductValues.CANDY.getName());
        System.out.println(candy.getName() + " FOR " + candy.getPrice() + " USD WAS SELECTED");
        System.out.println("INSERT COINS");

        vendingMachine.acceptCoin(CoinValues.NICKEL.getName(), candy.getPrice());
        vendingMachine.acceptCoin(CoinValues.DIME.getName(), candy.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), candy.getPrice());
        vendingMachine.returnCoins();

        System.out.println("<===============================>");
        cashRegister.printRegister();

        System.out.println("<===============================>");
        System.out.println("ON SHELVES:");
        inventory.printInventory();
        System.out.println("<===============================>");

        System.out.println("SELECT PRODUCT");
        Product coke = vendingMachine.selectProduct(ProductValues.COKE.getName());
        System.out.println(coke.getName() + " FOR " + coke.getPrice() + " USD WAS SELECTED");
        System.out.println("INSERT COINS");

        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), coke.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), coke.getPrice());
        vendingMachine.acceptCoin(CoinValues.DIME.getName(), candy.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), coke.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), coke.getPrice());

        System.out.println("<===============================>");
        cashRegister.printRegister();

        System.out.println("<===============================>");
        System.out.println("ON SHELVES:");
        inventory.printInventory();
        System.out.println("<===============================>");

        System.out.println("SELECT PRODUCT");
        Product secondCoke = vendingMachine.selectProduct(ProductValues.COKE.getName());
        System.out.println(secondCoke.getName() + " FOR " + secondCoke.getPrice() + " USD WAS SELECTED");
        System.out.println("INSERT COINS");

        vendingMachine.acceptCoin(CoinValues.DIME.getName(), secondCoke.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), secondCoke.getPrice());
        vendingMachine.acceptCoin(CoinValues.NICKEL.getName(), secondCoke.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), secondCoke.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), secondCoke.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), secondCoke.getPrice());

        System.out.println("<===============================>");
        cashRegister.printRegister();

        System.out.println("<===============================>");
        System.out.println("ON SHELVES:");
        inventory.printInventory();
        System.out.println("<===============================>");

        System.out.println("SELECT PRODUCT");
        Product chips = vendingMachine.selectProduct(ProductValues.CHIPS.getName());
        System.out.println(chips.getName() + " FOR " + chips.getPrice() + " USD WAS SELECTED");
        System.out.println("INSERT COINS");

        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), chips.getPrice());
        vendingMachine.acceptCoin(CoinValues.DIME.getName(), chips.getPrice());
        vendingMachine.acceptCoin(CoinValues.DIME.getName(), chips.getPrice());
        vendingMachine.acceptCoin(CoinValues.DIME.getName(), chips.getPrice());

        System.out.println("<===============================>");
        cashRegister.printRegister();

        System.out.println("<===============================>");
        System.out.println("ON SHELVES:");
        inventory.printInventory();
        System.out.println("<===============================>");

        System.out.println("SELECT PRODUCT");
        vendingMachine.selectProduct(ProductValues.COKE.getName());
        System.out.println("SELECT PRODUCT");
        Product secondChips = vendingMachine.selectProduct(ProductValues.CHIPS.getName());
        System.out.println(secondChips.getName() + " FOR " + secondChips.getPrice() + " USD WAS SELECTED");
        System.out.println("INSERT COINS");
        vendingMachine.acceptCoin(CoinValues.NICKEL.getName(), secondChips.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), secondChips.getPrice());
        vendingMachine.acceptCoin(CoinValues.NICKEL.getName(), secondChips.getPrice());
        vendingMachine.acceptCoin(CoinValues.NICKEL.getName(), secondChips.getPrice());
        vendingMachine.acceptCoin(CoinValues.NICKEL.getName(), secondChips.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), secondChips.getPrice());

        System.out.println("<===============================>");
        cashRegister.printRegister();

        System.out.println("<===============================>");
        System.out.println("ON SHELVES:");
        inventory.printInventory();
        System.out.println("<===============================>");

        System.out.println("SELECT PRODUCT");
        Product secondCandy = vendingMachine.selectProduct(ProductValues.CANDY.getName());
        System.out.println(secondCandy.getName() + " FOR " + secondCandy.getPrice() + " USD WAS SELECTED");
        System.out.println("INSERT COINS");

        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), secondCandy.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), secondCandy.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), secondCandy.getPrice());

        System.out.println("<===============================>");
        cashRegister.printRegister();

        System.out.println("<===============================>");
        System.out.println("ON SHELVES:");
        inventory.printInventory();
        System.out.println("<===============================>");

        System.out.println("SELECT PRODUCT");
        Product thirdCandy = vendingMachine.selectProduct(ProductValues.CANDY.getName());
        System.out.println(thirdCandy.getName() + " FOR " + thirdCandy.getPrice() + " USD WAS SELECTED");
        System.out.println("INSERT COINS");

        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), thirdCandy.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), thirdCandy.getPrice());
        vendingMachine.acceptCoin(CoinValues.QUARTER.getName(), thirdCandy.getPrice());

        System.out.println("<===============================>");
        cashRegister.printRegister();
    }
}
