package PGO5;

public class Ore extends Mineral {
    private final boolean metallic;

    public Ore(String name, int baseReagent, int power, boolean metallic) {
        super(name, baseReagent, power);
        this.metallic = metallic;
    }

    public boolean isMetallic() {
        return metallic;
    }

    @Override
    public int getReagent() {
        int reagent = super.getReagent();

        if (metallic) return reagent;
        else return reagent / 2;
    }

    @Override
    public String toString() {
        return super.toString() + ", metallic: " + metallic;
    }
}