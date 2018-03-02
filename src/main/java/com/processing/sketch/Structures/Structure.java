package com.processing.sketch.Structures;

import processing.core.PApplet;

public abstract class Structure {


    private final PApplet p;
    private int sType;
    private int health;

    public Structure(PApplet p, int structureType){
        this.p = p;
        this.sType = structureType;
    }

    public void draw() {
    }

    public void update() {
    }
}
