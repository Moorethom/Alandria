package com.processing.sketch.Resources;

import com.processing.sketch.Player;
import processing.core.PApplet;

public class Wealth extends Resource {

    private double wealthMod = 1;

    public Wealth(PApplet p, Player player) {
        super(p, player);
    }

    public void update() {
        wealthGained();
    }

    private void wealthGained() {
        wealthMod = player.research.activeWealthResearch();
        amount += (player.getPopulation()* wealthMod) / 60;
    }

    public void addWealth(double wealth) {
        amount += wealth;
    }

}
