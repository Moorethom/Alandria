package com.processing.sketch;

import processing.core.PApplet;

public class Hud {
    private final PApplet p;

    private int width;
    private int height;

    public Hud(PApplet p, int width, int height) {
        this.p = p;
        this.width = width;
        this. height = height;
    }

    public void draw() {
        p.rectMode(p.CORNER);
        p.rect(0,0,width,height/16);
    }

    public void update() {

    }
}
