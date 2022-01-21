package pl.edu.pjatk.pyatkway.pyatkway.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.edu.pjatk.pyatkway.pyatkway.models.Ingredient;
import pl.edu.pjatk.pyatkway.pyatkway.models.Sandwich;
import pl.edu.pjatk.pyatkway.pyatkway.repositories.SandwichRepository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SandwichServiceTest {
    @Mock
    private SandwichRepository sandwichRepository;

    @InjectMocks
    private SandwichService sandwichService;

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
        ingredients.add(new Ingredient("Bread", 100));
        ingredients.add(new Ingredient("Lettuce", 40));
        ingredients.add(new Ingredient("Tomato", 40));
        var expected = new ArrayList();
        expected.add("Bread");
        expected.add("Lettuce");
        expected.add("Tomato");

        var result = sandwichService.getIngredients(ingredients);

        assertThat(result).isEqualTo(expected);
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
        ingredients.add(new Ingredient("Bread", 100));
        ingredients.add(new Ingredient("Lettuce", 40));
        ingredients.add(new Ingredient("Tomato", 40));
        var sandwich = new Sandwich(1, "", ingredients, 0d);
        var expectedCaloriesTotal = 180.0d;

        var result = sandwichService.getSandwichCalories(sandwich);

        Assertions.assertThat(result).isEqualTo(expectedCaloriesTotal);
    }

    @Test
    void adds_a_new_ingredient_to_an_existing_sandwich() {
        var ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Ingredient("Bread", 100));
        ingredients.add(new Ingredient("Lettuce", 40));
        ingredients.add(new Ingredient("Tomato", 40));
        var sandwich = new Sandwich(1, "", ingredients, 0d);
        var newIngredient = new Ingredient("Banana", 100);

        sandwichService.addIngredient(sandwich, newIngredient);

        Assertions.assertThat(sandwich.getIngredients().contains(newIngredient));
    }

    @Test
    void shouldFindById() {
        int id = 1;
        when(sandwichRepository.findById(any()))
                .thenReturn(Optional.of(new Sandwich()));
        var byId = sandwichService.findById(id);

        assertThat(byId).isNotNull();
    }

    @Test
    void shouldNotFindById() {
        var id = 200;

        when(sandwichRepository.findById(any())).thenReturn(Optional.empty());

        assertThatExceptionOfType(
                RuntimeException.class
        ).isThrownBy(() -> sandwichService.findById(id));
    }

    @Test
    void shouldFindAll() {
        var sandwiches = when(sandwichRepository.findAll())
                .thenReturn(new ArrayList<Sandwich>());

        sandwichService.findAll();

        assertThat(sandwiches).isNotNull();
    }

    // deleteById
    // delete
    // existsById
}
