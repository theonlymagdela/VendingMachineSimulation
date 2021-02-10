import coins.*;
import products.*;

public class Counter {

    public static void main(String[] args) {
//        Display dp = new Display();
//
//        dp.welcome();
//        dp.selectProduct();

        VendingMachine vm = new VendingMachine();
        Printer pr = new Printer();
        Inventory inventory = vm.getInventory();
        CashRegister cashRegister = vm.getCashRegister();

        inventory.add(new Coke(2));
        inventory.add(new Candy(8));
        inventory.add(new Chips(3));

        cashRegister.add(new Nickel(CoinValues.NICKEL.getWeight(), CoinValues.NICKEL.getSize(), 5));
        cashRegister.add(new Dime(CoinValues.DIME.getWeight(), CoinValues.DIME.getSize(), 3));
        cashRegister.add(new Quarter(CoinValues.QUARTER.getWeight(), CoinValues.QUARTER.getSize(), 2));

        inventory.printInventory();
        System.out.println("SELECT PRODUCT");
        Product product = vm.selectProduct(ProductValues.COKE.getName());
        pr.display(String.format("%s FOR %s USD WAS SELECTED", product.getName(), product.getPrice()));

        pr.display("INSERT COIN");
        vm.acceptCoin(CoinValues.QUARTER.getName(), product.getPrice());
        pr.display("INSERT COIN");
        vm.acceptCoin(CoinValues.DIME.getName(), product.getPrice());
        pr.display("INSERT COIN");
        vm.acceptCoin(CoinValues.QUARTER.getName(), product.getPrice());
        pr.display("INSERT COIN");
        vm.acceptCoin(CoinValues.QUARTER.getName(), product.getPrice());
        pr.display("INSERT COIN");
        vm.acceptCoin(CoinValues.QUARTER.getName(), product.getPrice());

        cashRegister.printRegister();
    }
}
