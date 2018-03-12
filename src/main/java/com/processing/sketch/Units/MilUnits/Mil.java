package com.processing.sketch.Units.MilUnits;
import com.processing.sketch.Player;
import com.processing.sketch.Units.Unit;
import processing.core.PApplet;

public abstract class Mil extends Unit {

    public PApplet p;

    public Mil(PApplet p, int xPos, int yPos, Player player) {
        super(p, xPos, yPos,player);
        this.p = p;
    }

    public abstract void draw();
}

