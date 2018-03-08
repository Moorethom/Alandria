package com.processing.sketch.Resources;

import com.processing.sketch.Player;
import processing.core.PApplet;

public class Metal extends Resource {

    public Metal(PApplet p, Player player) {
        super(p, player);
    }

    public void update() {

    }

    public void addWealth(double metal) {
        amount += metal;
    }

    private void metalGain() {
        double tempMod;
        tempMod = player.research.activeMetalResearch();
        //calls a function inside the structures to check what metal structures are active and there output then times it by the tempMod
    }


}