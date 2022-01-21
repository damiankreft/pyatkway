package pl.edu.pjatk.pyatkway.pyatkway.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.edu.pjatk.pyatkway.pyatkway.models.Sandwich;
import pl.edu.pjatk.pyatkway.pyatkway.repositories.SandwichRepository;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class SandwichServiceIt {
    @MockBean
    private SandwichRepository sandwichRepository;

    @Autowired
    private SandwichService sandwichService;

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
}
