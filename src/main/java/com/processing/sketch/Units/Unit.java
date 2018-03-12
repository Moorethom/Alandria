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

    public int health;


    public Unit(PApplet p, int xPos, int yPos, Player player) {
        pos = new PVector(xPos, yPos);
        vel = new PVector(0, 0);
        accel = new PVector(0, 0);
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
        vel.add(accel);
        pos.add(vel);
        accel.mult(0);
    }

    public boolean checkIfDead() {
        if(health <= 0) return true; //checks if the unit is below 0 health
        return age >= maxAge; //checks if the unit is older than it should be
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
