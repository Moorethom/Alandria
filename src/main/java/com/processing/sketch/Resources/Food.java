package com.processing.sketch.Resources;

import com.processing.sketch.Player;
import processing.core.PApplet;

import java.util.Date;
import java.util.Timer;

public class Food extends Resource {

    public Food(PApplet p, Player player) {
        super(p, player);

    }

    public void update() {
        foodUsed();
        if(amount <=0) {
            applyFoodDebuff();
        }
    }

    public void foodUsed() {
        int pop = player.getPopulation();
        amount -= pop/600; //removes a population of food
    }
    
    public void applyFoodDebuff(){
        //this is a simple modifier 
    }

}
