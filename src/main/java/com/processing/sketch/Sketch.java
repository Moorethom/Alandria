package com.processing.sketch;

import processing.core.PApplet;


public class Sketch extends PApplet {


    World world;


    public void settings() {
        size(1280,720);
    }

    public void setup() {
        world = new World(this);
    }

    public void draw() {
    }

    public static void main(String[] args) {
        PApplet.main("com.processing.sketch.Sketch", args);
    }
}
