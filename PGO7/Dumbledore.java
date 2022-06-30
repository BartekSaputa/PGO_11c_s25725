package PGO7;

public class Dumbledore extends Character{

    public Dumbledore(String name, Location location) {
        super(name, location);
        setPower(10);
    }

    @Override
    public void moveTo(Location location) {
        setLocation(location);
    }

    public void moveTo(Orphanage orphange) {
        orphange.addChild(this);
        setLocation(Location.Orphanage);
    }
}