package pl.edu.pjatk.pyatkway.pyatkway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjatk.pyatkway.pyatkway.models.Sandwich;

import java.util.List;

public interface SandwichRepository extends JpaRepository<Sandwich, Integer> {
    List<Sandwich> findSandwichesByIdIsLessThan(Integer id);
    List<Sandwich> findSandwichesByNameContains(String name);
}
