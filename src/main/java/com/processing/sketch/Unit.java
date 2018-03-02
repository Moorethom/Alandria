package com.processing.sketch;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class Unit {

    private final PApplet p;
    private PVector pos;
    private PVector vel;
    private PVector accel;
    private float mass = 1;
    private int unitType;

    public Unit(PApplet p, int xPos, int yPos, int type) {
        this.pos.x = xPos;
        this.pos.y = yPos;
        this.unitType = type;
        vel = new PVector(0, 0);
        accel = new PVector(0, 0);
        this.p = p;
    }

    public void update() {
        vel.add(accel);
        pos.add(vel);
        accel.mult(0);
    }

    void applyForce(PVector force) {
        int xMax = getMaxSpeed();
        int yMax = xMax;

        if (vel.x >= xMax ) {
            vel.x = xMax;
        } else if (vel.x <= -xMax ) {
            vel.x = -xMax;
        }

        //Terminal velocity y value

        if (vel.y >= yMax ) {
            vel.y = yMax;
        } else if (vel.y <= -yMax ) {
            vel.y = -yMax;
        }

        //Calulations
        PVector f = PVector.div(force, mass);
        accel.add(f);
    }

    int getMaxSpeed(){
        int max = 0;

        return max;
    }
}
