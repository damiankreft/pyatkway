package pl.edu.pjatk.pyatkway.pyatkway.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SandwichRestControllerIt {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnSuccess_helloWorld() throws Exception {
        mockMvc.perform(get("/sandwich/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, world!"));
    }

    @Test
    public void shouldReturnSuccess_prepareSandwich() throws Exception {
        mockMvc.perform(get("/sandwich/prepare"))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
