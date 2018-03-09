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

    private Player player;

    public boolean toggleBuildings;
    public boolean toggleResearch;

    int widthDi;
    int heightDi;


    private ArrayList<Resource> resourcesTemp = new ArrayList<Resource>();  //0 = food, 1 = wealth, 2 = metal

    Hud(PApplet p, Player player, int width, int height) {
        this.p = p;
        this.width = width;
        this.height = height;
        this.player = player;
        this.resourcesTemp = player.resources;

        toggleBuildings = false;
        toggleResearch = false;

//        font = p.createFont("RobotoCondensed-Regular.ttf", 64, false);
        font = p.createFont("Arial", 64, false);

        widthDi = width/10; //Commonly used width Dimension
        heightDi = height/16; //Commonly used height Dimension
    }

    public void draw() {
        //p.rectMode(p.CORNER); //Sets CORNER mode if needed

        p.rect(0, 0, width, heightDi);  // This draws the Hud frame

        //Draws the boxes for the height and research
        p.rect(0,0, widthDi, heightDi);
        p.rect(width/10, 0,widthDi, heightDi);

        //Sets and the font and colors
        p.textFont(font);
        p.fill(0);
        p.textSize(32);

        //Draws the text for the research and buildings boxes
        p.text("Buildings", 32, height /24);
        p.text("Research", 30+widthDi, height/24);

        //Sets the resource values for the specific associated resource
        p.text("Food: " + convertFloat(foodTemp), 32+widthDi*2, (height / 24));
        p.text("Wealth: " + convertFloat(wealthTemp), widthDi*3, (height / 24));
        p.text("Metal: " + convertFloat(metalTemp), widthDi*4, (height / 24));
        p.text("Pop: " + player.getPopulation(), widthDi*5, (height / 24));
    }

    public void update() {
        foodTemp = resourcesTemp.get(0).getAmount();
        wealthTemp = resourcesTemp.get(1).getAmount();
        metalTemp = resourcesTemp.get(2).getAmount();
    }

    public String convertFloat(Float f) {
        return String.format("%.0f", f);
    }


    public void toggleBuildings() {
        toggleBuildings ^= true;
    }

    public void toggleResearch() {
        toggleResearch ^= true;
    }
}
