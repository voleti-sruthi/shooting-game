package com.example.shootinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
@ExtendWith(MockitoExtension.class)
public class ShootingServiceTest {
    @InjectMocks
    public ShootingService shootingService;

    @Mock
    private Character hero;
    @Mock
    private VillainCharacter villain;
    @BeforeEach
    void setUp(){
        shootingService.setHealth("hero",100);
        shootingService.setHealth("villain",100);
        shootingService.setArmour(true);
    }
    @Nested
    class toCheckInitialSetUp{
        @Test
        void toGetHeroHealth(){
            int health = 100;
            Mockito.when(hero.getHealth()).thenReturn(health);
            int health1 = shootingService.health("hero");
            assertThat(health1,is(equalTo(health)));
            verify(hero).getHealth();
        }
        @Test
        void toGetVillainHealth(){
            int health = 100;
            Mockito.when(villain.getHealth()).thenReturn(health);
            int health1 = shootingService.health("villain");
            assertThat(health1,is(equalTo(health)));
            verify(villain).getHealth();
        }

        @Test
        void toGetArmourStatus(){
            boolean armourStatus = false;
            Mockito.when(villain.getArmour()).thenReturn(false);
            assertThat(shootingService.getArmour(),is(equalTo(armourStatus)));
            verify(villain).getArmour();
        }
    }
    @Nested
    class toCheckArmourStatusOnChange{
        @Test
        void toGetArmourAsTrueOnSettingIt(){
            boolean armourStatus = true;
            Mockito.when(villain.getArmour()).thenReturn(true);
            Mockito.doNothing().when(villain).setArmour(false);
            shootingService.setArmour(false);
            assertThat(shootingService.getArmour(),is(equalTo(armourStatus)));
        }
        @Test
        void toGetArmourAsFalseOnRemovingIt(){
            boolean armourStatus = false;
            Mockito.when(villain.getArmour()).thenReturn(false);
            Mockito.doNothing().when(villain).setArmour(true);
            shootingService.setArmour(true);
            assertThat(shootingService.getArmour(),is(equalTo(armourStatus)));
        }
    }
    @Nested
    class toCheckIfHealthChangesOnShootOfHero{
        @Test
        void toGetHeroHealthAfterShoot(){
            Mockito.when(hero.getHealth()).thenReturn(80);
            int healthAfterShoot = 80;
            shootingService.shoot("hero");
            assertThat(shootingService.health("hero"),is(equalTo(healthAfterShoot)));
        }
        @Test
        void toGetHeroHealthAfter2Shots(){
            Mockito.when(hero.getHealth()).thenReturn(60);
            int healthAfterShoot = 60;
            shootingService.shoot("hero");
            assertThat(shootingService.health("hero"),is(equalTo(healthAfterShoot)));
        }
    }
    @Nested
    class toCheckIfHealthChangesOnShootOfVillainWithoutArmour{
        @Test
        void toGetVillainHealthAfterShootWithOutArmour(){
            Mockito.when(villain.getHealth()).thenReturn(80);
            int healthAfterShoot = 80;
            shootingService.shoot("villain");
            assertThat(shootingService.health("villain"),is(equalTo(healthAfterShoot)));
        }
        @Test
        void toGetVillainHealthAfter2ShootWithOutArmour(){
            Mockito.when(villain.getHealth()).thenReturn(60);
            int healthAfterShoot = 60;
            shootingService.shoot("villain");
            shootingService.shoot("villain");
            assertThat(shootingService.health("villain"),is(equalTo(healthAfterShoot)));
        }
    }

    @Nested
    class toCheckIfHealthChangesOnShootOfVillainWithArmour{
        @Test
        void toGetVillainHealthAfterShotsWithArmour(){
            int healthAfterShoot = 90;
            Mockito.when(villain.getArmour()).thenReturn(true);
            Mockito.doNothing().when(villain).setArmour(false);
            Mockito.when(villain.getHealth()).thenReturn(90);
            shootingService.setArmour(false);
            shootingService.shoot("villain");
            assertThat(shootingService.health("villain"),is(equalTo(healthAfterShoot)));
        }
        @Test
        void toGetVillainHealthAfter2ShotsWithArmour(){
            int healthAfterShoot = 80;
            Mockito.when(villain.getArmour()).thenReturn(true);
            Mockito.doNothing().when(villain).setArmour(false);
            Mockito.when(villain.getHealth()).thenReturn(80);
            shootingService.setArmour(false);
            shootingService.shoot("villain");
            shootingService.shoot("villain");
            assertThat(shootingService.health("villain"),is(equalTo(healthAfterShoot)));
        }
        @Test
        void toGetVillainHealthAfter2ShotsWithAndWithOutArmour(){
            int healthAfterShoot = 70;
            Mockito.when(villain.getArmour()).thenReturn(true);
            Mockito.doNothing().when(villain).setArmour(false);
            Mockito.when(villain.getHealth()).thenReturn(70);
            shootingService.shoot("villain");
            shootingService.setArmour(false);
            shootingService.shoot("villain");
            assertThat(shootingService.health("villain"),is(equalTo(healthAfterShoot)));
        }
    }



}
