import coins.*;
import products.Product;

public class Counter {

    public static void main(String[] args) {

        VendingMachine vendingMachine = new VendingMachine();

        var inventory = vendingMachine.getInventory();
        var cashRegister = vendingMachine.getCashRegister();

        System.out.println("<==============================>");
        System.out.println("Little machine around a corner");
        System.out.println("<==============================>");
        System.out.println("Currently on shelves:");
        for (Product product: inventory.getProducts()) {
            System.out.println(product);
        }
        System.out.println("<==============================>");

        System.out.println("Moneys in register:");

        for (Coin coin: cashRegister.getCoins()) {
            System.out.println(coin);
        }
        System.out.println("Total coins: " + cashRegister.howManyCoinsTotal());
        System.out.println("<==============================>");

        System.out.println("What would you like to buy?");
        Product newProduct = vendingMachine.pickProduct("candy");
        System.out.println(newProduct.getName() + " for " + newProduct.getPrice() + " USD was chosen");
        System.out.println("Please add coins");
        vendingMachine.acceptCoin(new Nickel(CoinValues.NICKEL.getWeight(), CoinValues.NICKEL.getSize()));
        vendingMachine.stillToPay(newProduct.getPrice());
        vendingMachine.acceptCoin(new Quarter(CoinValues.QUARTER.getWeight(), CoinValues.QUARTER.getSize()));
        vendingMachine.stillToPay(newProduct.getPrice());
        vendingMachine.acceptCoin(new Dime(CoinValues.DIME.getWeight(), CoinValues.DIME.getSize()));
        vendingMachine.stillToPay(newProduct.getPrice());
        vendingMachine.acceptCoin(new Dime(CoinValues.DIME.getWeight(), CoinValues.DIME.getSize()));
        vendingMachine.stillToPay(newProduct.getPrice());
        vendingMachine.acceptCoin(new Quarter(CoinValues.QUARTER.getWeight(), CoinValues.QUARTER.getSize()));
        vendingMachine.stillToPay(newProduct.getPrice());

    }
}
