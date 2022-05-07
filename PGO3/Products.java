package src;

public class Products {

    private String name;
    private ProductType productType;
    private double price;
    private int quantity;
    private Storage storage;

    public Products(String name, ProductType productType, double price, int quantity) {
        this.name = name;
        this.productType = productType;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void sell(){
        quantity--;
    }

    public void increaseQuantity(int quantity){
        this.quantity += quantity;
    }

    public Storage getStorage() {
        return storage;
    }
}