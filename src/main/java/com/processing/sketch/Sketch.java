package com.processing.sketch;

import processing.core.PApplet;

import java.util.ArrayList;

public class Sketch extends PApplet {


    World world;
    AI ai; //This will probibly be a useless class so it can fuck off
    Hud hud;



    public void settings() {
        size(1280,720, P2D);
    }

    public void setup() {
        world = new World(this);
        hud = new Hud(this);
        world.setup();
    }


    public void draw() { //Main Draw function to call shit
        world.draw();
    }

    public static void main(String[] args) {
        PApplet.main("com.processing.sketch.Sketch", args);
    }
}
