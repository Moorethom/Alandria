package com.processing.sketch;


import processing.core.PApplet;
import processing.core.PVector;

public class Camera {

    public final PApplet p;

    public PVector pos;
    public int width;
    public int height;


    public Camera(PApplet p, int width, int height) {
        this.p = p;
        pos = new PVector(0, 0);
        this.width = width;
        this.height = height;
    }

    // translate camera position in terms of target.
    void update(PVector target) {
        pos.x = target.x - (width / 2);
        pos.y = target.y - (height / 2);
    }

}
