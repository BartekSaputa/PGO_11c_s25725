package PGO5;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws Exception {
        Elixir drink = new Elixir("Mohito");
        Alcohol alcohol = new Alcohol("Gin", 10000, 50, 45);
        Water sparklingwater = new Water("Sparkling water", 1000, 50, false);
        Flower lemon = new Flower("Lemon", 5000, 1);
        Crystal ice = new Crystal("Ice", 100000, 10, 1);
        drink.setCatalyst(alcohol);
        drink.addIngredient(sparklingwater);
        drink.addIngredient(lemon);
        drink.addIngredient(ice);
        drink.addIngredient(ice);
        drink.removeIngredient(ice);
        drink.Create();
        System.out.println("Power: " + drink.getPower());
    }
}