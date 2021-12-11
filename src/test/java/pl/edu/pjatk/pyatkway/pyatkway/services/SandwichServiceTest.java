package pl.edu.pjatk.pyatkway.pyatkway.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.edu.pjatk.pyatkway.pyatkway.models.Ingredient;
import pl.edu.pjatk.pyatkway.pyatkway.models.Sandwich;

import java.util.ArrayList;
import java.util.UUID;

class SandwichServiceTest {
    private SandwichService sandwichService = new SandwichService(null);

    @Test
    void set_sandwich_name_to_given_value() {
        // Given
        var defaultName = "testName";
        var newName = "newSandwichName";
        var sandwich = new Sandwich(0, defaultName, null, 5.0d);
        // When
        sandwichService.setSandwichName(sandwich, newName);
        // Then
        Assertions.assertThat(newName).isEqualTo(newName);
    }

    @Test
    void throws_exception_when_sandwich_does_not_exist() {
        var newName = "newSandwichName";
        var sandwich = (Sandwich)null;

        Assertions.assertThatNullPointerException()
                .isThrownBy(() -> {
                    sandwichService.setSandwichName(sandwich, newName);
                }).withMessage("Sandwich is null.");
    }


    @Test
    void returns_names_of_all_ingredients_separated_by_coma() {
        var ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Ingredient(UUID.randomUUID(), "Bread", 100));
        ingredients.add(new Ingredient(UUID.randomUUID(), "Lettuce", 40));
        ingredients.add(new Ingredient(UUID.randomUUID(), "Tomato", 40));
        var expected = new ArrayList();
        expected.add("Bread");
        expected.add("Lettuce");
        expected.add("Tomato");

        var result = sandwichService.getIngredients(ingredients);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void update_sandwich_price() {
        var sandwich = new Sandwich(1, "", null, 5.0d);
        var newPrice = 10.0d;

        sandwichService.updateSandwichPrice(sandwich, newPrice);

        Assertions.assertThat(sandwich.getPrice()).isEqualTo(newPrice);
    }

    @Test
    void update_sandwich_price_does_not_update_price_if_newPrice_is_equal_or_below_zero() {
        var oldPrice = 5.0d;
        var invalidPrice = -10.0d;
        var sandwich = new Sandwich(1, "", null, oldPrice);

        sandwichService.updateSandwichPrice(sandwich, invalidPrice);

        Assertions.assertThat(sandwich.getPrice()).isEqualTo(oldPrice);
    }

    @Test
    void returns_the_sum_of_calories_of_sandwichs_ingredients() {
        var ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Ingredient(UUID.randomUUID(), "Bread", 100));
        ingredients.add(new Ingredient(UUID.randomUUID(), "Lettuce", 40));
        ingredients.add(new Ingredient(UUID.randomUUID(), "Tomato", 40));
        var sandwich = new Sandwich(1, "", ingredients, 0d);
        var expectedCaloriesTotal = 180.0d;

        var result = sandwichService.getSandwichCalories(sandwich);

        Assertions.assertThat(result).isEqualTo(expectedCaloriesTotal);
    }
}
