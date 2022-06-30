package PGO5;

public abstract class Mineral extends Ingredient {
    public int getPower() {
        return power;
    }

    private final int power;

    public Mineral(String name, int baseReagent, int power) {
        super(name, baseReagent);
        this.power = power;
    }

    public int getReagent() {
        return super.getReagent() + power;
    }

    @Override
    public String toString() {
        return super.toString() + ", power: " + power;
    }
}