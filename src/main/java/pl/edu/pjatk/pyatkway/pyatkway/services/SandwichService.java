package pl.edu.pjatk.pyatkway.pyatkway.services;

import org.springframework.stereotype.Service;
import pl.edu.pjatk.pyatkway.pyatkway.models.Ingredient;
import pl.edu.pjatk.pyatkway.pyatkway.models.Sandwich;

import java.util.List;
import java.util.UUID;

@Service
public class SandwichService {
    public Sandwich CreateSandwich() {
        Ingredient pork = new Ingredient(UUID.randomUUID(), "Pork", 100);
        Ingredient bread = new Ingredient(UUID.randomUUID(), "White bread", 100);
        var sandwich = new Sandwich(UUID.randomUUID(), "Pork sandwich", List.of(pork, bread), 5.0d);

        return sandwich;
    }

    public Sandwich GetSandwich(String name) {
        return null;
    }
}
