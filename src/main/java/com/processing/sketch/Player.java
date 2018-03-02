package com.processing.sketch;

import com.processing.sketch.Resources.Food;
import com.processing.sketch.Resources.Metal;
import com.processing.sketch.Resources.Resource;
import com.processing.sketch.Resources.Wealth;
import com.processing.sketch.Structures.Structure;
import com.processing.sketch.Units.Civ;
import com.processing.sketch.Units.Unit;
import processing.core.PApplet;
import java.util.ArrayList;

public class Player {


    private final PApplet p;

    ArrayList<Structure> pStructures = new ArrayList<Structure>();
    ArrayList<Unit> units = new ArrayList<Unit>();
    ArrayList<Resource> resources = new ArrayList<Resource>();

    private int popCap = 500;
    private double popMod = 0;
    private double baseMod =0.1;
    private double newPop = 0;


    public Player(PApplet p) {
        this.p = p;
        resources.add(new Food(p, this));
        resources.add(new Metal(p, this));
        resources.add(new Wealth(p, this));
        //units.add(new Civ(p, 100,100,0)); //This is for testing only
    }


    public void draw() {

        this.update();

        if(units == null) return;
        for(Structure s : pStructures){
            s.update();
            s.draw();
        }
        for(Unit u : units){
            u.update();
            u.draw();
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
