package coins;

import java.util.ArrayList;
import java.util.List;

public class CashRegister {

    private final List<Coin> coins = new ArrayList<>();

    public List<Coin> getCoins() {

        coins.add(new Nickel(5.01, 0.835));
        coins.add(new Dime(2.28, 0.705));
        coins.add(new Quarter(5.67, 0.955));

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
        return coins.size();
    }

    public void add(Coin coin) {
        coins.add(coin);
    }

    public void removeByName(String name) {
        coins.removeIf(coin -> coin.getName().equals(name));
    }
}
