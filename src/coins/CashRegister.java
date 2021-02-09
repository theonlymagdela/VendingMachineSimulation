package coins;

import java.util.ArrayList;
import java.util.List;

public class CashRegister {

    private final List<Coin> coins = new ArrayList<>();

    public List<Coin> getCoins() {
        return coins;
    }

    public int howManyCoinsByName(String name) {
        int count = 0;

        for(Coin coin: coins) {
            if(coin.getName().equals(name)) {
                count++;
                return count;
            }
        }
        return count;
    }

    public int howManyCoinsTotal() {
        int total = 0;

        for(Coin coin: coins) {
            total = total + coin.getQuantity();
        }
        return total;
    }

    public void add(Coin coin) {
        coins.add(coin);
    }

    public void addQuantity(String name) {
        for(Coin coin: coins) {
            if(coin.getName().equals(name)) {
                coin.setQuantity(coin.getQuantity() + 1);
            }
        }
    }

    public void subtractQuantity(String name) {
        for(Coin coin: coins) {
            if(coin.getName().equals(name)) {
                coin.setQuantity(coin.getQuantity() - 1);
            }
        }
    }

    public Coin getByName(String name) {
        for(Coin coin: coins) {
            if(coin.getName().equals(name)) {
                return coin;
            }
        }
        return null;
    }

    public void remove(Coin coin) {
        coins.remove(coin);
    }

    public void printRegister() {
        for(Coin coin: coins) {
            System.out.println(coin);
        }
    }
}