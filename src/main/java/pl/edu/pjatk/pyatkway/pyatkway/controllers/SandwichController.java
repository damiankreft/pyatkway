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
    public ResponseEntity<Sandwich> getSandwich() {
        var sandwich = sandwichService.createSandwich();
        return ResponseEntity.ok(sandwich);
    }

    @GetMapping("prepare")
    public ResponseEntity<Sandwich> prepareSandwich() {
        var sandwich = sandwichService.prepareSandwich("ultra_sandwich");
        return ResponseEntity.ok(sandwich);
    }
}
