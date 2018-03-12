package com.processing.sketch.Structures;

import processing.core.PApplet;

public class Capital extends Structure{

    int width = 200;
    int height = 200;

    public Capital(PApplet p, int xPos, int yPos) {
        super(p, xPos, yPos);
    }

    public void draw() {
        p.rect(pos.x,pos.y,width,height);

    }


    public void update() {
    }
}

