package pl.edu.pjatk.pyatkway.pyatkway.services;

import org.springframework.stereotype.Service;
import pl.edu.pjatk.pyatkway.pyatkway.models.Ingredient;
import pl.edu.pjatk.pyatkway.pyatkway.models.Sandwich;
import pl.edu.pjatk.pyatkway.pyatkway.repositories.SandwichRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SandwichService {
    private final SandwichRepository repository;
    public SandwichService(SandwichRepository repository) {
        this.repository = repository;
    }

    public Sandwich createSandwich() {
        var pork = createIngredient("Pork", 100);
        var bread = createIngredient("White bread", 100);

        return createSandwich("Pork sandwich", 5.0d, List.of(pork, bread));
    }

    public Sandwich addSandwich(Sandwich sandwich) {
        return repository.save(sandwich);
    }

    public Sandwich prepareSandwich(String name) {
        var bread = createIngredient("White bread", 100);
        var sandwich = createSandwich("Just a BIG Sandwich", 5.0d, List.of(bread));

        return repository.save(sandwich);
    }

    public List<Sandwich> getTop5() {
        return repository.findSandwichesByIdIsLessThan(5);
    }

    public List<Sandwich> getUltra() {
        return repository.findSandwichesByNameContains("ultra_sandwich");
    }

    public void addIngredient(Sandwich sandwich, Ingredient ingredient) {
        var ingredients = sandwich.getIngredients();
        if (ingredients != null && ingredient != null) {
            ingredients.add(ingredient);
        }
    }

    public Sandwich createSandwich(String name, double price, List<Ingredient> ingredients) {
        return new Sandwich(0, name, ingredients, price);
    }

    public Ingredient createIngredient(String name, int calories) {
        return new Ingredient(name, calories);
    }

    public double getSandwichCalories(Sandwich sandwich) {
        if (sandwich == null || sandwich.getIngredients() == null) {
            throw new NullPointerException("Sandwich or ingredients list is null");
        }

        var calories = 0;

        for (var i : sandwich.getIngredients()) {
            if (i == null) {
                throw new NullPointerException("Ingredient is null");
            }

            calories += i.getCalories();
        }

        return calories;
    }

    public void setSandwichName(Sandwich sandwich, String name) {
        if (sandwich == null) {
            throw new NullPointerException("Sandwich is null.");
        }

        sandwich.setName(name);
    }

    public void updateSandwichPrice(Sandwich sandwich, double price) {
        if (sandwich == null) {
            throw new NullPointerException("Sandwich is null.");
        }

        if (price >= 0.0d) {
            sandwich.setPrice(price);
        }
    }

    public List<String> getIngredients(List<Ingredient> ingredients) {
        var ingredientNames = new ArrayList<String>();

        if (ingredients == null) {
            throw new NullPointerException("Ingredients list is null.");
        }

        for (var i : ingredients) {
            if (i == null) {
                throw new NullPointerException("Ingredient is null");
            }
            ingredientNames.add(i.getName());
        }

        return ingredientNames;
    }

    public Sandwich findById(int id) {
        Optional<Sandwich> byId = repository.findById(id);
        return byId.orElseThrow(RuntimeException::new);
    }

    public List<Sandwich> findAll() {
        var all = repository.findAll();
        return all;
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public void delete(Sandwich sandwich) {
        repository.delete(sandwich);
    }

    public boolean existsById(int id) {
        return repository.existsById(id);
    }
}
