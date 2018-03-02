package com.processing.sketch;
import processing.core.PApplet;
import processing.core.PVector;

public class Mil implements Unit {

    private final PApplet p;
    private PVector pos;
    private PVector vel;
    private PVector accel;
    private float mass = 1;

    public Mil(PApplet p, int xPos, int yPos) {
        this.pos.x = xPos;
        this.pos.y = yPos;
        vel = new PVector(0, 0);
        accel = new PVector(0, 0);
        this.p = p;
    }

    public void update() {

    }
}
