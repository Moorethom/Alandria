package com.processing.sketch.Structures;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class Structure {


    public final PApplet p;
    private int health;

    public PVector pos;


    public Structure(PApplet p, int xPos, int yPos){
        this.p = p;
        this.pos = new PVector(xPos, yPos);
    }

    public abstract void draw();

    public abstract void update();

}
