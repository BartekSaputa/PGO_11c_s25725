package PGO5;

public class Root extends Mineral {

    public Root(String name, int baseReagent, int power) {
        super(name, baseReagent, power);
    }

    @Override
    public int getReagent() {
        return super.getReagent() / 2;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}