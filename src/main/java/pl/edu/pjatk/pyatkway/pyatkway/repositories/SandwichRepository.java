package pl.edu.pjatk.pyatkway.pyatkway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjatk.pyatkway.pyatkway.models.Sandwich;

public interface SandwichRepository extends JpaRepository<Sandwich, Integer> {

}
