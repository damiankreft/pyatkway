package pl.edu.pjatk.pyatkway.pyatkway.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pjatk.pyatkway.pyatkway.models.Sandwich;
import pl.edu.pjatk.pyatkway.pyatkway.services.SandwichService;

@RestController
@RequestMapping("/sandwich")
public class SandwichController {
    private final SandwichService sandwichService;

    public SandwichController(SandwichService sandwichService) {
        this.sandwichService = sandwichService;
    }

    @GetMapping("")
    public ResponseEntity<Sandwich> GetSandwich() {
        var sandwich = sandwichService.CreateSandwich();
        return ResponseEntity.ok(sandwich);
    }
}
