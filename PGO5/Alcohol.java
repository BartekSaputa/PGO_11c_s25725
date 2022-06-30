package PGO5;

public class Alcohol extends Liquid {
    private final int percent;

    public Alcohol(String name, int baseReagent, int dissolubility, int percent) throws Exception {
        super(name, baseReagent, dissolubility);
        if (0 > percent || percent > 100) throw new Exception("Percent should be in the range from 0 to 100");
        this.percent = percent;
    }

    public int getPercent() {
        return percent;
    }

    @Override
    public int getReagent() {
        return super.getReagent() * percent / 100;
    }

    @Override
    public String toString() {
        return super.toString() + ", percent: " + percent;
    }
}