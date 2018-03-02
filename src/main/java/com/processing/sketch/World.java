package com.processing.sketch;

import processing.core.PApplet;

import java.util.ArrayList;


public class World {

    private final PApplet p;
    ArrayList<Player> players = new ArrayList<Player>();

    void setup() {
        players.add(new Player(p)); //TODO this might fuck all my shit up and will/ might need changing
        p.background(255);
    }

    void draw() {

        if (players == null) return;
        for (Player play : players) {
            play.draw();
        }

    }
    //add the world generation here


    public World(PApplet p) {
        this.p = p;

    }

}
