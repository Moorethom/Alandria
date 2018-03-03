package com.processing.sketch.Structures;

import processing.core.PApplet;

public class House extends Structure{

    int width = 50;;
    int height = 50;;

    public House(PApplet p, int xPos, int yPos) {
        super(p, xPos, yPos);
    }

    public void draw() {
        p.rect(pos.x,pos.y,width,height);

    }


    public void update() {
    }
}
