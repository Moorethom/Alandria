package com.processing.sketch.Structures;

import processing.core.PApplet;

public class Stable extends Structure{

    int width = 60;
    int height = 60;

    public Stable(PApplet p, int xPos, int yPos) {
        super(p, xPos, yPos);
    }

    public void draw() {
        p.rect(pos.x,pos.y,width,height);

    }


    public void update() {
    }
}
