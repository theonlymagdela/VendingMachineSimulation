import coins.CoinValues;
import products.ProductValues;

import java.util.Scanner;

public class Printer {

    Scanner scanner = new Scanner(System.in);

    public void display(String text) {
        System.out.println(text);
    }

    public void beautifyingTrail() {
        System.out.println("<====================================>");
    }

    public String selectProduct() {
        String result = "";
        
        display("SELECT PRODUCT");
        display("1 FOR COKE");
        display("2 FOR CANDY");
        display("3 FOR CHIPS");
        int input = Integer.parseInt(scanner.nextLine());
        
        switch (input) {
            case 1:
                result = ProductValues.COKE.getName();
                break;
            case 2:
                result = ProductValues.CANDY.getName();
                break;
            case 3:
                result = ProductValues.CHIPS.getName();
                break;
        }
        return result;
    }

    public String giveCoin() {
        String result = "";

        display("INSERT COIN");
        display("1 FOR NICKEL");
        display("2 FOR DIME");
        display("3 FOR QUARTER");
        display("4 FOR RETURNING COINS");
        int input = Integer.parseInt(scanner.nextLine());

        switch (input) {
            case 1:
                result = CoinValues.NICKEL.getName();
                break;
            case 2:
                result = CoinValues.DIME.getName();
                break;
            case 3:
                result = CoinValues.QUARTER.getName();
                break;
            case 4:
                result = "break";
        }
        return result;
    }
}
