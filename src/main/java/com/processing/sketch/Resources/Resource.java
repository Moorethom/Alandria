package com.processing.sketch.Resources;

import processing.core.PApplet;

public abstract class Resource {

    private final PApplet p;
    private int amount;

    public Resource(PApplet p) {
        amount = 0;
        this.p = p;
    }

    public int getAmount(){
        return amount;
    }

    public void update(){}

}
