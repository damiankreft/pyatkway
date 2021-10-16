package pl.edu.pjatk.pyatkway.pyatkway.models;

import pl.edu.pjatk.pyatkway.pyatkway.enums.Vitamins;

public class Vitamin {
    private Vitamins type;
    private int amount;
    
    public Vitamin(Vitamins type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public Vitamins getType() {
        return type;
    }

    public void setType(Vitamins type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
