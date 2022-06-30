package PGO7;

public class Riddle extends Child {

    private final Location location = Location.London;
    public Riddle(String name, Location location) {
        super(name, location);
        setPower(5);
    }

    @Override
    public Location getLocation()
    {
        return location;
    }
}