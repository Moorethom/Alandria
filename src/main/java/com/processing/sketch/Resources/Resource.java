package com.processing.sketch.Resources;

import com.processing.sketch.Player;
import processing.core.PApplet;

public abstract class Resource {

    private final PApplet p;
    public float amount;
    public Player player;

    public Resource(PApplet p, Player player) {
        this.p = p;
        this.player = player;
        amount = 0;
    }

    public float getAmount(){
        return amount;
    }

    public abstract void update();

}
