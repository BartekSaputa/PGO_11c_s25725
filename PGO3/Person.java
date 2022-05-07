package src;

import java.util.List;

public class Person {
    private String name;
    private String surname;
    private double moneyInCash;
    private double moneyOnCard;
    private ShoppingCart current;
    private List<ShoppingCart> shoppingHistory;

    public void makeOrder(){
        current = new ShoppingCart();
    }

    public void buyByCard(){
        if(current.getTotalPrice() <= moneyOnCard){
            current.sell();
            shoppingHistory.add(current);
        }
    }

    public void buyInCash(){
        if(current.getTotalPrice() <= moneyInCash){
            current.sell();
            shoppingHistory.add(current);
        }
    }
}