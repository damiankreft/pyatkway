package pl.edu.pjatk.pyatkway.pyatkway.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.pyatkway.pyatkway.models.Sandwich;
import pl.edu.pjatk.pyatkway.pyatkway.services.SandwichService;

import java.util.List;

@RestController
@RequestMapping("/sandwich")
public class SandwichController {
    private final SandwichService sandwichService;

    public SandwichController(SandwichService sandwichService) {
        this.sandwichService = sandwichService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello, world!");
    }

    @GetMapping("")
    public ResponseEntity<Sandwich> getSandwich() {
        var sandwich = sandwichService.createSandwich();
        return ResponseEntity.ok(sandwich);
    }

    @GetMapping("/prepare")
    public ResponseEntity<Sandwich> prepareSandwich(@RequestParam String sandwichName) {
        var sandwich = sandwichService.prepareSandwich(sandwichName);
        return ResponseEntity.ok(sandwich);
    }

    @GetMapping("topfive")
    public ResponseEntity<List<Sandwich>> top5() {
        var top5 = sandwichService.getTop5();
        return ResponseEntity.ok(top5);
    }

    @GetMapping("ultra")
    public ResponseEntity<List<Sandwich>> ultra() {
        var ultra = sandwichService.getUltra();
        return ResponseEntity.ok(ultra);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sandwich> findById(@PathVariable int id) {
        return ResponseEntity.ok(sandwichService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<Sandwich> addSandwich(@RequestBody Sandwich sandwich) {
        return ResponseEntity.ok(sandwichService.addSandwich(sandwich));
    }
}
