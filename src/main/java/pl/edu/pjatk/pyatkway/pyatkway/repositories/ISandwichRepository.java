package pl.edu.pjatk.pyatkway.pyatkway.repositories;

import pl.edu.pjatk.pyatkway.pyatkway.models.Sandwich;

import java.util.List;

public interface ISandwichRepository {
    void addAsync();
    public Sandwich getAsync(String name);
    public List<Sandwich> getAll();
    public void remove();
    public void update();
}
