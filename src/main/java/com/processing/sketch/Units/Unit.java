package com.processing.sketch.Units;

import processing.core.PApplet;
import processing.core.PVector;



public abstract class Unit {

    final PApplet p;
    PVector pos;
    PVector vel;
    PVector accel;
    float mass = 1;
    int unitType;

    public Unit(PApplet p, int xPos, int yPos, int type) {
        pos = new PVector(xPos, yPos);
        vel = new PVector(0, 0);
        accel = new PVector(0, 0);
        this.unitType = type;
        this.p = p;
    }

    public void update() {
        vel.add(accel);
        pos.add(vel);
        accel.mult(0);
    }

    void applyForce(PVector force) {
        int max = getMaxSpeed();

        force.limit(max);

        PVector f = PVector.div(force, mass);
        accel.add(f);
    }

    int getMaxSpeed(){
        int max = 0;
        if(unitType >=0 && unitType <= 99) { max = 10; }
        if(unitType >=100 && unitType <= 199) { max = 15; }
        return max;
    }

    public abstract void draw();
}
