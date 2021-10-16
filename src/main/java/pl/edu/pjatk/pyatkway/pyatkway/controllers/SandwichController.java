package pl.edu.pjatk.pyatkway.pyatkway.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pjatk.pyatkway.pyatkway.models.Ingredient;
import pl.edu.pjatk.pyatkway.pyatkway.models.Sandwich;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sandwich")
public class SandwichController {

    @GetMapping("")
    public ResponseEntity<Sandwich> GetSandwich() {
        Ingredient pork = new Ingredient(UUID.randomUUID(), "Pork", 100);
        Ingredient bread = new Ingredient(UUID.randomUUID(), "White bread", 100);
        var sandwich = new Sandwich(UUID.randomUUID(), "Pork sandwich", List.of(pork, bread), 5.0d);
        return ResponseEntity.ok(sandwich);
    }
}
