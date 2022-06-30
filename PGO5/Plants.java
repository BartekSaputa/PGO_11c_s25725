package PGO5;

public abstract class Plants extends Ingredient {
    public int getToxity() {
        return toxity;
    }

    private final int toxity;

    public Plants(String name, int baseReagent, int toxity) {
        super(name, baseReagent);
        this.toxity = toxity;
    }

    public int getReagent() {
        return super.getReagent() * toxity;
    }

    @Override
    public String toString() {
        return super.toString() + ", toxity: " + toxity;
    }
}