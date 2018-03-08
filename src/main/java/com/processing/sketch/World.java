package com.processing.sketch;

import processing.core.PApplet;

import java.awt.*;
import java.util.ArrayList;


public class World {

    private final PApplet p;

    private int numberOfPlayers = 1;
    public ArrayList<Player> players = new ArrayList<Player>();

    Color[] colors = new Color[8];

    public World(PApplet p) {
        this.p = p;
    }

    void setup() {
        setColors();
        for(int i = 0; i<=numberOfPlayers; i++) {
            players.add(new Player(p,colors[i])); //This is for testing only
        }
        p.background(255);
        //p.rectMode(p.CENTER); //sets center if needed
    }

    void draw() {
        if (players == null) return;
        for (Player play : players) {
            play.draw();
        }
    }

    void setColors(){
        colors[0] = (Color.red);
        colors[1] = (Color.blue);
        colors[2] = (Color.green);
        colors[3] = (Color.orange);
        colors[4] = (Color.cyan);
        colors[5] = (Color.yellow);
        colors[6] = (Color.magenta);
        colors[7] = (Color.white);
    }

    //add the world generation here

}
