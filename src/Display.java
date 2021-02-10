import coins.*;
import products.*;

public class Display {

    private final VendingMachine vm = new VendingMachine();
    private final Printer pr = new Printer();
    private final Inventory inventory = vm.getInventory();
    private final CashRegister cashRegister = vm.getCashRegister();

    public void welcome() {
        pr.beautifyingTrail();
        pr.display("LITTLE MACHINE AROUND A CORNER");
        pr.beautifyingTrail();
        addToInventory();
        addToRegister();
    }

    public void selectProduct() {
        while(true) {
            getInventory();

            Product product = vm.selectProduct(pr.selectProduct());
            pr.display(String.format("%s FOR %s USD WAS SELECTED", product.getName(), product.getPrice()));

            boolean paying = vm.acceptCoin(pr.giveCoin(), product.getPrice());
            while(paying) {
                if(pr.giveCoin().equals("break")) {
                    vm.returnCoins();
                }
                vm.acceptCoin(pr.giveCoin(), product.getPrice());
            }
            pr.beautifyingTrail();
        }
    }

    public void getInventory() {
        pr.display("ON SHELVES:");
        pr.display("~~~~~~~~~~~~");
        for(Product product: inventory.getProducts()) {
            System.out.println(product);
        }
        pr.beautifyingTrail();
    }

    private void addToRegister() {
        cashRegister.add(new Nickel(CoinValues.NICKEL.getWeight(), CoinValues.NICKEL.getSize(), 5));
        cashRegister.add(new Dime(CoinValues.DIME.getWeight(), CoinValues.DIME.getSize(), 3));
        cashRegister.add(new Quarter(CoinValues.QUARTER.getWeight(), CoinValues.QUARTER.getSize(), 1));
    }

    private void addToInventory() {
        inventory.add(new Coke(2));
        inventory.add(new Candy(8));
        inventory.add(new Chips(3));
    }
}
