package com.processing.sketch;

import processing.core.PApplet;

import java.util.ArrayList;

public class Player {

    private final PApplet p;

    ArrayList<Structures> pStructures = new ArrayList<Structures>();
    ArrayList<Unit> units = new ArrayList<Unit>();


    public Player(PApplet p) {
        this.p = p;
    }
}
