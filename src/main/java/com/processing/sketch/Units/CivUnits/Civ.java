package com.processing.sketch.Units.CivUnits;

import com.processing.sketch.Player;
import com.processing.sketch.Units.Unit;
import processing.core.PApplet;

public abstract class Civ extends Unit {

    public PApplet p;


    public Civ(PApplet p, int xPos, int yPos, Player player) {
        super(p, xPos, yPos, player);
        this.p = p;
    }


    public void draw() {
        p.rect(pos.x,pos.y,16,16);
    }
}
