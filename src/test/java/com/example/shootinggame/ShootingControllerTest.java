package com.example.shootinggame;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ShootingController.class)
public class ShootingControllerTest {
    @MockBean
    private ShootingService shootingService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldGetHeroHealth() throws Exception {
        Mockito.when(shootingService.health("hero")).thenReturn(100);
        mockMvc.perform(MockMvcRequestBuilders.get("/health/hero"))
                .andExpect(status().isOk()).andExpect(content().string(equalTo("100")));
    }

    @Test
    void shouldGetVillainHealth() throws Exception {
        Mockito.when(shootingService.health("villain")).thenReturn(100);
        mockMvc.perform(MockMvcRequestBuilders.get("/health/villain"))
                .andExpect(status().isOk()).andExpect(content().string(equalTo("100")));
    }

    @Test
    void shouldReduceHealthOfHeroIfVillainShoots() throws Exception{
        Mockito.when(shootingService.shoot("Hero")).thenReturn(80);
        mockMvc.perform(MockMvcRequestBuilders.post("/shoot?characterName=Hero"))
                .andExpect(status().isOk()).andExpect(content().string(equalTo("80")));
    }

    @Test
    void shouldReduceHealthOfVillainIfHeroShoots() throws Exception{
        Mockito.when(shootingService.shoot("Villain")).thenReturn(80);
        mockMvc.perform(MockMvcRequestBuilders.post("/shoot?characterName=Villain"))
                .andExpect(status().isOk()).andExpect(content().string(equalTo("80")));
    }
    @Test
    void shouldReduceHealthOfVillainIfHeroShootsWithArmour() throws Exception{
        Mockito.when(shootingService.getArmour()).thenReturn(false);
        mockMvc.perform(MockMvcRequestBuilders.post("/armour/true"))
                .andExpect(status().isOk()).andExpect(content().string(equalTo("false")));
    }

}



