import coins.Coin;

import java.util.ArrayList;
import java.util.List;

public class CurrentSelect {

    private final List<String> listOfCoins = new ArrayList<>();
    private String productName;

    public CurrentSelect() {
    }

    public List<String> getListOfCoins() {
        return listOfCoins;
    }

    public void addToList(String name) {
        listOfCoins.add(name);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void emptyList() {
        for(int i = 0; i < listOfCoins.size(); i++) {
            listOfCoins.set(i, null);
        }
    }

    public void printTheList() {
        System.out.println("RETURNING COINS");
        for(String string: listOfCoins) {
            System.out.println(string);
        }
    }
}
