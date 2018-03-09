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
        font = p.createFont("Arial", 64, false);
    }

    public void draw() {
        //p.rectMode(p.CORNER); //Sets CORNER mode if needed

        p.rect(0, 0, width, height / 16);  // This draws the Hud frame
        p.rect(0,0,width/10,height/16);
        p.rect(width/10,0,(width/10),height/16);

        //Draws the resources values
        p.textFont(font);
        p.fill(0);
        p.textSize(32);

        p.text("Buildings", 25, height /24);
        p.text("Research", 32+(width/10),height/24);

        p.text("Food: " + convertFloat(foodTemp), 32+(width / 10)*2, (height / 24));
        p.text("Wealth: " + convertFloat(wealthTemp), (width / 10)*3, (height / 24));
        p.text("Metal: " + convertFloat(metalTemp), (width / 10)*4, (height / 24));
        p.text("Pop: " + player.getPopulation(), (width / 10)*5, (height / 24));
    }

    public void update() {
        foodTemp = resourcesTemp.get(0).getAmount();
        wealthTemp = resourcesTemp.get(1).getAmount();
        metalTemp = resourcesTemp.get(2).getAmount();
    }

    public String convertFloat(Float f) {
        return String.format("%.0f", f);
    }

}
