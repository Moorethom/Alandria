package com.processing.sketch;

import processing.core.PApplet;

import java.util.ArrayList;


public class World {

    private final PApplet p;
    ArrayList<Player> players = new ArrayList<Player>();

    void setup() {
        players.add(new Player(p));
        p.background(255);
    } //setup for the world

    void draw() {

        //for (Player players : p) {
            //draw the structures and units in here
        //}

    }
    //add the world generation here


    public World(PApplet p) {
        this.p = p;

    }

}
