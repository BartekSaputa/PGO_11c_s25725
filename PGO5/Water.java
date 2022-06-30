package PGO5;

public class Water extends Liquid {
    private final boolean distilated;

    public Water(String name, int baseReagent, int dissolubility, boolean distilated) throws Exception {
        super(name, baseReagent, dissolubility);
        this.distilated = distilated;
    }

    public boolean isDistilated() {
        return distilated;
    }

    @Override
    public int getReagent() {
        int reagent = super.getReagent();

        if (distilated) return reagent;
        else return reagent / 2;
    }

    @Override
    public String toString() {
        return super.toString() + ", distilated: " + distilated;
    }
}