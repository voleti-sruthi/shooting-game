package com.example.shootinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(classes = Character.class)
//@ContextConfiguration(classes = Character.class)
//@WebMvcTest(Character.class)
public class CharacterTest {
    @BeforeEach
    void initBeforeEach(){
        hero.setHealth(100);
    }
    @Autowired
    public Character hero;
    @Test
    void toGetHeroHealth(){
        int startingHealth = 100;
        assertThat(hero.getHealth(),is(equalTo(startingHealth)));
    }

}
