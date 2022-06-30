package PGO5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Elixir {
    private final String name;
    private final List<Ingredient> ingredients = new ArrayList();
    private int power = 0;
    private boolean isCreated = false;
    private Liquid catalyst = null;

    public Elixir(String name) {
        this.name = name;
    }

    public boolean isCreated() {
        return this.isCreated;
    }

    public int getPower() throws Exception {
        if (!this.isCreated) {
            throw new Exception("Power cannot be calculated if elixir is not created");
        } else {
            return this.power;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setCatalyst(Liquid catalyst) throws Exception {
        if (this.isCreated) {
            throw new Exception("You cannot change the catalyst if a elixir has already been created");
        } else {
            this.catalyst = catalyst;
        }
    }

    void addIngredient(Ingredient ingredient) throws Exception {
        if (this.isCreated) {
            throw new Exception("You cannot add the ingredient if a elixir has already been created");
        } else {
            this.ingredients.add(ingredient);
        }
    }

    void removeIngredient(Ingredient ingredient) throws Exception {
        if (this.isCreated) {
            throw new Exception("You cannot remove the ingredient if a elixir has already been created");
        } else {
            Ingredient ingredientToRemove = null;
            Iterator var3 = this.ingredients.iterator();

            while(var3.hasNext()) {
                Ingredient iteratedIngredient = (Ingredient)var3.next();
                if (Objects.equals(iteratedIngredient.toString(), ingredient.toString())) {
                    ingredientToRemove = iteratedIngredient;
                    break;
                }
            }

            if (ingredientToRemove == null) {
                throw new Exception("You cannot remove an ingredient if it is not in the elixir");
            } else {
                this.ingredients.remove(ingredientToRemove);
            }
        }
    }

    void Create() throws Exception {
        if (this.isCreated) {
            throw new Exception("You cannot create the elixir a second time");
        } else if (this.ingredients.isEmpty()) {
            throw new Exception("You cannot create a elixir without ingredients");
        } else if (this.catalyst == null) {
            throw new Exception("You cannot create a elixir without catalyst");
        } else {
            Ingredient i;
            for(Iterator var1 = this.ingredients.iterator(); var1.hasNext(); this.power += i.getReagent()) {
                i = (Ingredient)var1.next();
            }

            this.power /= this.catalyst.getReagent();
            this.isCreated = true;
        }
    }
}