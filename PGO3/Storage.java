package src;

import java.util.List;

public class Storage {
    private int deliveryTime;

    public void setDeliveryTime(int deliveryTime) {
        if(deliveryTime > 0)
            this.deliveryTime = deliveryTime;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }
}