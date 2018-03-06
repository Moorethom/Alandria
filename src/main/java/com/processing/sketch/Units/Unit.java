package com.processing.sketch.Units;

import com.processing.sketch.Player;
import processing.core.PApplet;
import processing.core.PVector;

import java.awt.*;


public abstract class Unit {

    public final PApplet p;
    public PVector pos;
    public PVector vel;
    public PVector accel;
    public float mass = 1;
    public int unitType;
    public double age;
    public double maxAge;
    public Player player;
    public int col;


    public Unit(PApplet p, int xPos, int yPos, int type, Player player) {
        pos = new PVector(xPos, yPos);
        vel = new PVector(0, 0);
        accel = new PVector(0, 0);
        this.unitType = type;
        this.p = p;
        this.player = player;
        age = 0;
        getMaxAge();
        col = p.color(255,255,255);

    }

    private void getMaxAge() {
        maxAge = p.random(45,75);
    }

    public void update() {
        growOlder();
        p.fill(col);

        vel.add(accel);
        pos.add(vel);
        accel.mult(0);
    }

    public boolean checkIfDead() {
        if(age>=maxAge){
            return true;
        }
        return false;
    }

    protected void growOlder() {
        age += player.deathTime;
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

    public void newCol(){
        col = p.color(255,0,0);
    }

}
