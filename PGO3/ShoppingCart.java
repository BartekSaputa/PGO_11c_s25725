package src;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final int id;
    private static int nextId = 1;
    private List<Products> products = new ArrayList<>();

    public ShoppingCart() {
        id = nextId;
        nextId++;
    }

    public double getTotalPrice(){
        double totalPrice = 0;
        for(Products product: products)
            totalPrice += (product.getPrice() * product.getQuantity());
        return totalPrice;
    }

    public double getDeliveryTime(){
        int totalDeliveryTime = 0;
        for(Products product: products)
            if(product.getStorage() != null)
                totalDeliveryTime += product.getStorage().getDeliveryTime();
        return totalDeliveryTime;
    }

    public void sell(){
        for(Products product: products)
            product.sell();
    }
}