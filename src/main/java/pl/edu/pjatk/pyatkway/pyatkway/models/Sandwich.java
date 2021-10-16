package pl.edu.pjatk.pyatkway.pyatkway.models;

import java.util.List;
import java.util.UUID;

public class Sandwich {
    private final UUID guid;
    private String name;
    private List<Ingredient> ingredients;
    private double price;
    
    public Sandwich(UUID guid, String name, List<Ingredient> ingredients, double price) {
        this.guid = guid;
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }

    public UUID getGuid() {
        return guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCalories() {
        int caloriesTotal = 0;
        for (var i : ingredients) {
            caloriesTotal += i.getCalories();
        }

        return caloriesTotal;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "guid=" + guid +
                ", name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", price=" + price +
                '}';
    }
}
