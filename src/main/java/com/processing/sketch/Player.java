package com.processing.sketch;

import com.processing.sketch.Resources.*;
import com.processing.sketch.Structures.House;
import com.processing.sketch.Structures.Structure;
import com.processing.sketch.Units.Civ;
import com.processing.sketch.Units.Unit;
import processing.core.PApplet;

import java.awt.*;
import java.util.ArrayList;

public class Player {


    public final PApplet p;

    public ArrayList<Structure> pStructures = new ArrayList<Structure>();
    public ArrayList<Unit> units = new ArrayList<Unit>();
    public ArrayList<Resource> resources = new ArrayList<Resource>();
    public Research research;

    private int popCap = 500;
    private double popMod = 0;
    private double baseMod =0.006;
    private double newPop = 0;
    public Color playerCol;


    public Player(PApplet p, Color c) {
        this.playerCol = c;
        this.p = p;
        resources.add(new Food(p, this));
        resources.add(new Metal(p, this));
        resources.add(new Wealth(p, this));
        research = new Research(p);

        //This is for testing only

        //units.add(new Civ(p, 100,100,0));
        //pStructures.add(new House(p,100,100));

    }


    public void draw() {

        this.update();

        if(pStructures != null) {
            for (Structure s : pStructures) {
                s.update();
                s.draw();
            }
        }
        if(units != null) {
            for (Unit u : units) {
                u.update();
                u.draw();
            }
        }
    }

    public void update(){
        this.addToPopulation();
        this.updatePopMod();
        this.createNewPop();
    }

    public int getPopulation(){
        if(units == null) return 0;
        return units.size();
    }

    public void addToPopulation(){
        if(this.getPopulation() >= popCap) return;
        newPop += popMod;
    }

    public void updatePopMod(){
        popMod = (getPopulation() * baseMod);
    }

    public void createNewPop(){
        if(newPop >= 1){
            units.add(new Civ(p, 0,0,0));
        }
    }
}
