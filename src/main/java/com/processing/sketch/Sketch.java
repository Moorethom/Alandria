package com.processing.sketch;

import processing.core.PApplet;

import java.util.ArrayList;


public class Sketch extends PApplet {


    World world;
    AI ai;
    Hud hud;
    ArrayList<Player> players = new ArrayList<Player>();


    public void settings() {
        size(1280,720, P2D);
    }

    public void setup() {
        world = new World(this);
        hud = new Hud(this);
        players.add(new Player(this));


    }

    public void draw() {
    }

    public static void main(String[] args) {
        PApplet.main("com.processing.sketch.Sketch", args);
    }
}
