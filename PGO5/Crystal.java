package PGO5;

public class Crystal extends Mineral {
    private final int magicPower;

    public Crystal(String name, int baseReagent, int power, int magicPower) {
        super(name, baseReagent, power);
        this.magicPower = magicPower;
    }

    public int getMagicPower() {
        return magicPower;
    }

    @Override
    public int getReagent() {
        return super.getReagent() + magicPower;
    }

    @Override
    public String toString() {
        return super.toString() + ", magicPower: " + magicPower;
    }
}