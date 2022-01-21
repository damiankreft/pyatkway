package pl.edu.pjatk.pyatkway.pyatkway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.edu.pjatk.pyatkway.pyatkway.models.Ingredient;
import pl.edu.pjatk.pyatkway.pyatkway.models.Sandwich;
import pl.edu.pjatk.pyatkway.pyatkway.services.SandwichService;

import java.util.List;

@SpringBootApplication
public class PyatkwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PyatkwayApplication.class, args);
	}

	@Bean
	public CommandLineRunner appSetup(@Autowired SandwichService sandwichService) {
		return args -> {
			System.out.println("Starting CommandLineRunner...");
			var ingredients = List.of(new Ingredient("ingredient1", 50), new Ingredient("Just Pork", 100));
			var ingredients2 = List.of(new Ingredient("ingredient2", 50), new Ingredient("True Pork", 100));
			var ingredients3 = List.of(new Ingredient("ingredient3", 50), new Ingredient("Fake Pork", 100));
			var ingredients4 = List.of(new Ingredient("ingredient3", 50), new Ingredient("Weird-looking Pork", 100));
			sandwichService.addSandwich(new Sandwich(0, "Tinky", ingredients, 20.0));
			sandwichService.addSandwich(new Sandwich(0, "Winky", ingredients2, 20.0));
			sandwichService.addSandwich(new Sandwich(0, "Lala", ingredients3, 20.0));
			sandwichService.addSandwich(new Sandwich(0, "Po", ingredients4, 20.0));
		};
	}
}
