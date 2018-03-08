package com.processing.sketch;

import com.processing.sketch.Resources.Resource;
import processing.core.PApplet;
import processing.core.PFont;

import java.util.ArrayList;

public class Hud {

    private final PApplet p;
    PFont font;
    private int width;
    private int height;
    private float wealthTemp;
    private float metalTemp;
    private float foodTemp;
    private int popTemp;
    private Player player;

    private ArrayList<Resource> resourcesTemp = new ArrayList<Resource>();  //0 = food, 1 = wealth, 2 = metal

    Hud(PApplet p, Player player, int width, int height) {
        this.p = p;
        this.width = width;
        this.height = height;
        this.player = player;
        this.resourcesTemp = player.resources;

//        font = p.createFont("RobotoCondensed-Regular.ttf", 64, false);
        font = p.createFont(PFont.list()[0], 64, false);
    }

    public void draw() {
        //p.rectMode(p.CORNER); //Sets CORNER mode if needed

        p.rect(0, 0, width, height / 16);  // This draws the Hud frame

        //Draws the resources values
        p.textFont(font);
        p.textSize(32);
        p.text(convertFloat(foodTemp), (width / 2), (height / 5));
    }

    public void update() {
        foodTemp = resourcesTemp.get(0).getAmount();
        wealthTemp = resourcesTemp.get(1).getAmount();
        metalTemp = resourcesTemp.get(2).getAmount();
    }

    public String convertFloat(Float f) {
        return String.valueOf(f);
    }

}
