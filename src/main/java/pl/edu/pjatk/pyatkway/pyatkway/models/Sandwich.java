package pl.edu.pjatk.pyatkway.pyatkway.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Sandwich")
public class Sandwich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany
    private List<Ingredient> ingredients;
    private double price;

    public Sandwich() {

    }

    public Sandwich(int id, String name, List<Ingredient> ingredients, double price) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }

    public int getId() {
        return id;
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
                "guid=" + id +
                ", name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", price=" + price +
                '}';
    }
}
