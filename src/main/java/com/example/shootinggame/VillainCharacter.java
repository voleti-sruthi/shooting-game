package com.example.shootinggame;
public class VillainCharacter extends Character{
    private boolean armour = false;
    public void setArmour(boolean setArmourValue){

        this.armour = !setArmourValue;
    }
    public boolean getArmour(){
        return this.armour;
    }
}
