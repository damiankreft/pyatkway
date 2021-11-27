package pl.edu.pjatk.pyatkway.pyatkway.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pjatk.pyatkway.pyatkway.models.Sandwich;
import pl.edu.pjatk.pyatkway.pyatkway.services.SandwichService;

import java.time.LocalDate;
import java.util.List;

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
}
