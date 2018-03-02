package com.processing.sketch;

import com.processing.sketch.Resources.Food;
import com.processing.sketch.Resources.Resource;
import com.processing.sketch.Structures.Structure;
import com.processing.sketch.Units.Unit;
import processing.core.PApplet;
import java.util.ArrayList;

public class Player {


    private final PApplet p;

    ArrayList<Structure> pStructures = new ArrayList<Structure>();
    ArrayList<Unit> units = new ArrayList<Unit>();
    ArrayList<Resource> resources = new ArrayList<Resource>();

    public Player(PApplet p) {
        this.p = p;
        resources.add(new Food(p));
        //units.add(new Mil(p, 100,100,1)); //This is for testing only
    }


    public void draw() {
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

    public int getPopulation(){
        return units.size();
    }
}
