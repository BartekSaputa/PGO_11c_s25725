package PGO5;

public abstract class Liquid extends Ingredient {
    private final int dissolubility;

    public Liquid(String name, int baseReagent, int dissolubility) throws Exception {
        super(name, baseReagent);
        if (0 > dissolubility || dissolubility > 100)
            throw new Exception("Solubility should be in the range from 0 to 100");
        this.dissolubility = dissolubility;
    }

    public int getDissolubility() {
        return dissolubility;
    }

    @Override
    public int getReagent() {
        return super.getReagent() * dissolubility / 100;
    }

    @Override
    public String toString() {
        return super.toString() + ", dissolubility: " + dissolubility;
    }

}