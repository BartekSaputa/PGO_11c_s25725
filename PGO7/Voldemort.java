package PGO7;

import java.util.ArrayList;
import java.util.List;

public class Voldemort extends Character{

    List<String> horcruxList = new ArrayList<String>();
    List<Character> targets = new ArrayList<Character>();;

    @Override
    public void moveTo(Location location) throws StoryViolationException{

    }

    public Voldemort(Character character) {

        super("Lord Voldemort", character.location);
        delete(character);
        setPower(7);

    }

    public void target(Character character) {
        targets.add(character);
    }

    public void castSpell(String spell) {
        for (int i = 0; i < targets.size(); i++)
        {
            if (this.getPower() > targets.get(i).getPower())
            {
                targets.get(i).die();
            }
            else {
                targets.get(i).lol();
                this.die();
            }
        }
        
    }

    public void createHorcruxes(int n) {
        int actualSize = horcruxList.size();
        for (int i = 1; i <= n; i++)
        {
            horcruxList.add("horcrux " +(i  + actualSize));
        }
    }

    public void printHorcruxes() {
        System.out.println("Created horcruxes:");

        for (int i = 0; i < horcruxList.size(); i++)
        {
            System.out.println("\t" + horcruxList.get(i));
        }

    }

    public Location getLocation() throws StoryViolationException {

throw new StoryViolationException("sf");

    }

}