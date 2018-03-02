package com.processing.sketch.Resources;

import com.processing.sketch.Player;
import processing.core.PApplet;

public class Wealth extends Resource{

    public Wealth(PApplet p, Player player) {
        super(p, player);
    }

    public void update() {
        wealthGained();
    }

    private void wealthGained() {
        int pop = player.getPopulation();
        amount += pop/60;
    }
}
