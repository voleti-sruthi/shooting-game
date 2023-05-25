package com.example.shootinggame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShootingController {
    @Autowired
    private ShootingService shootingService;

    @GetMapping("/health/{characterName}")
    public int getHealth(@PathVariable String characterName){
        return shootingService.health(characterName);
    }

    @PostMapping("/shoot")
    public int shoot(@RequestParam String characterName){
        return shootingService.shoot(characterName);
    }
    @PostMapping("/armour/{statusOfArmour}")
    public boolean setArmour(@PathVariable boolean statusOfArmour){
        shootingService.setArmour(statusOfArmour);
        return shootingService.getArmour();
    }
}
