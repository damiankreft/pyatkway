package pl.edu.pjatk.pyatkway.pyatkway.models;

import pl.edu.pjatk.pyatkway.pyatkway.enums.Vitamins;

import javax.persistence.*;

@Entity
@Table(name = "Vitamins")
public class Vitamin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Vitamins type;
    private int amount;
    
    public Vitamin(int id, Vitamins type, int amount) {
        this.id = id;
        this.type = type;
        this.amount = amount;
    }

    public Vitamin() {

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
