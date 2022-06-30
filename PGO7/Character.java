package PGO7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Character {
    protected Location location;
    private String name;

    private int status = 100;

    private int power;

    private static List<Character> listOfCharacters = new ArrayList<Character>();

    Character(String name, Location location)
    {
        this.location = location;
        this.name = name;

        listOfCharacters.add(this);

    }

    protected void delete(Character character)
    {
        listOfCharacters.remove(character);
        character = null;


    }

    static public void status() {
        listOfCharacters.sort(Comparator.comparing(Character::getPower));
        System.out.println("====Status====");
        for (int i = 0; i < listOfCharacters.size(); i++)
        {
            System.out.println(listOfCharacters.get(i).getName() + ": " + listOfCharacters.get(i).status);
        }
        System.out.println("==============");
    }

    public static void MoveAllTo(Location hogwarts, Child tom, Dumbledore albus) {

    }

    public static void doSth(String string, Character... characters) {
        int n = characters.length;
        for (int i = 0; i < n; i++)
        {
            System.out.println("I am " + characters[i].getName() + ", I am defending");
        }
    }
    
    public void doSth(String string) {
        System.out.println("I am " + name + ", I am " + string);
    }

    public void introduce(){
        System.out.println("Hello, I am " + name);
    }

    public Location getLocation() throws StoryViolationException {

        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void say(String s, Character character) {
        System.out.println(name + " to "  + character.getName());
        System.out.println("\t" + s);
    }

    public abstract void moveTo(Location hogwarts) throws StoryViolationException;

    protected void setPower(int i)
    {
        power = i;
    }

    protected int getPower()
    {
        return power;
    }

    protected void die() {
        this.status = 0;
        System.out.println(this.name + " died.");
    }

    protected void lol() {
        System.out.println(this.name + " goes LOL...");
    }
}