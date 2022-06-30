package PGO7;

public class Potter extends Child{

    public Potter(String name, Location location) {
        super(name, location);
        if (name == "Lily")
        {
            setPower(4);
        }
        else if (name == "James")
        {
            setPower(6);
        }
        else if (name == "Harry")
        {
            setPower(8);
        }
    }

}