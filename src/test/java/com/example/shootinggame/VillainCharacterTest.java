package com.example.shootinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
@SpringBootTest(classes = VillainCharacter.class)
//@WebMvcTest(VillainCharacter.class)
public class VillainCharacterTest {
    @BeforeEach
    void initBeforeEach(){
        villain.setHealth(100);
        villain.setArmour(true);
    }
    @Autowired
    public VillainCharacter villain;
    @Test
    void toGetVillainHealth(){
        int startingHealth = 100;
        assertThat(villain.getHealth(),is(equalTo(startingHealth)));
    }

    @Test
    void toGetArmourAsTrueOnSettingIt(){
        boolean armourStatus = false;
        villain.setArmour(villain.getArmour());
        villain.setArmour(villain.getArmour());
        assertThat(villain.getArmour(),is(equalTo(armourStatus)));
    }

}
