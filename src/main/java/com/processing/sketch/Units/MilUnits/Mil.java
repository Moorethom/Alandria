package com.processing.sketch.Units.MilUnits;
import com.processing.sketch.Player;
import com.processing.sketch.Units.Unit;
import processing.core.PApplet;

public abstract class Mil extends Unit {

    public PApplet p;

    public Mil(PApplet p, int xPos, int yPos, int type, Player player) {
        super(p, xPos, yPos, type, player);
        this.p = p;
    }

    public abstract void draw();
}

