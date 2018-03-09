package com.processing.sketch.Structures;

import processing.core.PApplet;

public class Barracks extends Structure{

    int width = 80;
    int height = 80;

    public Barracks(PApplet p, int xPos, int yPos) {
        super(p, xPos, yPos);
    }

    public void draw() {
        p.rect(pos.x,pos.y,width,height);

    }


    public void update() {
    }
}