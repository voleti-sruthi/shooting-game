package com.example.shootinggame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShootingService {
//   @Autowired
//   private Character hero;
   final Character hero = new Character();
//   @Autowired
//   private VillainCharacter villain;
   final VillainCharacter villain = new VillainCharacter();
   int health(String characterName){
      return (characterName.equals("hero"))?hero.getHealth(): villain.getHealth();
   }
   void setHealth(String characterName,int currHealth){
      if(characterName.equals("hero")){
         hero.setHealth(currHealth);
      }
      else{
         villain.setHealth(currHealth);
      }
   }
   int shoot(String characterName){
      int presentHealth=100;
      if(characterName.equals("hero")){
         this.setHealth("hero",this.health("hero")-20);
         presentHealth = this.health("hero");
      }
      else{
         if(this.getArmour()){
            this.setHealth("villain",this.health("villain")-10);
         }
         else{
            this.setHealth("villain",this.health("villain")-20);
         }
         presentHealth = this.health("villain");
      }
      return presentHealth;
   }
   void setArmour(boolean statusOfArmour){
      villain.setArmour(statusOfArmour);
   }
   boolean getArmour(){
      return villain.getArmour();
   }
}
