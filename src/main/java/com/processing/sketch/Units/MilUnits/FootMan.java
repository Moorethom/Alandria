package com.processing.sketch.Units.MilUnits;

import com.processing.sketch.Player;
import processing.core.PApplet;

public class FootMan extends Mil {

    public PApplet p;

    public FootMan(PApplet p, int xPos, int yPos, Player player) {
        super(p, xPos, yPos, player);
        this.p = p;
    }

    public void draw() {
        p.rect(pos.x,pos.y,16,16);
    }

}
