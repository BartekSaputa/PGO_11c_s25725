package PGO7;

import java.util.ArrayList;
import java.util.List;

public class Orphanage {

    private String name;
    private Location location;
    private List<Character> list;
    public Orphanage (String name, Location location) {
        this.name = name;
        this.location = location;
        list = new ArrayList<Character>();
    }
    public void addChild(Character charactrer) {
        list.add(charactrer);
    }
}