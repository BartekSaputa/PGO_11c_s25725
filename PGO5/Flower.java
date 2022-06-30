package PGO5;

public class Flower extends Plants {
    public Flower(String name, int baseReagent, int toxity) {
        super(name, baseReagent, toxity);
    }

    @Override
    public int getReagent() {
        return super.getReagent() * 2;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}