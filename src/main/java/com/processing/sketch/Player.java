package com.processing.sketch;

import processing.core.PApplet;

import java.util.ArrayList;

public class Player {

    private final PApplet p;

    ArrayList<Structure> pStructures = new ArrayList<Structure>();
    ArrayList<Unit> units = new ArrayList<Unit>();
    ArrayList<Resource> resources = new ArrayList<Resource>();


    public Player(PApplet p) {
        this.p = p;
        //units.add(new Mil(p, 100,100,1));//TODO this is a temerory addition of a unit and needs to be removed
    }


    public void draw() {
        if(units == null) return;
        for(Structure s : pStructures){
            s.draw();
        }
        for(Unit u : units){
            u.draw();
        }
    }
}
