package PGO5;

public abstract class Ingredient {
    private final String name;
    private final int baseReagent;

    public Ingredient(String name, int baseReagent) {
        this.name = name;
        this.baseReagent = baseReagent;
    }

    public String getName() {
        return name;
    }

    public int getReagent() {
        return baseReagent;
    }

    @Override
    public String toString() {
        return name + " - baseReagent: " + baseReagent;
    }

}