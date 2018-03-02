package com.processing.sketch.Units;

import processing.core.PApplet;

public class Civ extends Unit{


    public Civ(PApplet p, int xPos, int yPos, int type) {
        super(p, xPos, yPos, type);
    }


    public void draw() {
        p.rect(pos.x,pos.y,16,16);
    }
}
