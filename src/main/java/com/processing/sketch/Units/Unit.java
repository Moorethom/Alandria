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

    public double mass = 1;
    public double maxSpeed = 30;

    public int unitType;

    public double age;
    public double maxAge;
    public int maxAgeMod = 60;

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
        maxAge = p.random(maxAgeMod-25,maxAgeMod+25);
    }

    public void update() {
        growOlder();
        p.fill(col);

        vel.add(accel);
        pos.add(vel);
        accel.mult(0);
    }

    public boolean checkIfDead() {
        return age >= maxAge;
    }

    protected void growOlder() {
        age += player.deathTime;
    }

    void applyForce(PVector force) {

        force.limit((float)maxSpeed);

        PVector f = PVector.div(force, (float)mass);
        accel.add(f);
    }

    public abstract void draw();

    public void newCol(){
        col = p.color(255,0,0);
    }

}
