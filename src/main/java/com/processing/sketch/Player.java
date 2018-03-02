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
    }
}
