package pl.edu.pjatk.pyatkway.pyatkway.models;

import java.util.List;
import java.util.UUID;

public class Ingredient {
    private final UUID guid;
    private String name;
    private int calories;
    private int totalFat;
    private int cholesterol;
    private int sodium;
    private int potassium;
    private int totalCarbohydrate;
    private int totalProtein;
    private List<Vitamin> vitamins;

    public Ingredient(UUID guid, String name, int calories) {
        this.guid = guid;
        this.name = name;
        this.calories = calories;
    }

    public Ingredient(UUID guid, String name, int calories, int totalFat, int cholesterol, int sodium, int potassium, int totalCarbohydrate, int totalProtein, List<Vitamin> vitamins) {
        this.guid = guid;
        this.name = name;
        this.calories = calories;
        this.totalFat = totalFat;
        this.cholesterol = cholesterol;
        this.sodium = sodium;
        this.potassium = potassium;
        this.totalCarbohydrate = totalCarbohydrate;
        this.totalProtein = totalProtein;
        this.vitamins = vitamins;
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

    public int getCalories() {
        return calories;
    }

    public int getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(int totalFat) {
        this.totalFat = totalFat;
    }

    public int getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(int cholesterol) {
        this.cholesterol = cholesterol;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getPotassium() {
        return potassium;
    }

    public void setPotassium(int potassium) {
        this.potassium = potassium;
    }

    public int getTotalCarbohydrate() {
        return totalCarbohydrate;
    }

    public void setTotalCarbohydrate(int totalCarbohydrate) {
        this.totalCarbohydrate = totalCarbohydrate;
    }

    public int getTotalProtein() {
        return totalProtein;
    }

    public void setTotalProtein(int totalProtein) {
        this.totalProtein = totalProtein;
    }

    public List<Vitamin> getVitamins() {
        return vitamins;
    }

    public void setVitamins(List<Vitamin> vitamins) {
        this.vitamins = vitamins;
    }
}
