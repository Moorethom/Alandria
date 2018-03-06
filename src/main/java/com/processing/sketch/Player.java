package com.processing.sketch;

import com.processing.sketch.Resources.*;
import com.processing.sketch.Structures.House;
import com.processing.sketch.Structures.Structure;
import com.processing.sketch.Units.CivUnits.Civ;
import com.processing.sketch.Units.CivUnits.Workless;
import com.processing.sketch.Units.MilUnits.FootMan;
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

    private int popCap = 100000;
    private double popMod = 0; //The final addition population increase per tick
    private double baseMod = 0.00006; //The base modifier of the population growth
    public double deathTime = 0.002; //The rate at which units age //0.002

    private double newPop = 0; //1 = new pop

    public Color playerCol; //Player color


    public Player(PApplet p, Color c) {
        this.playerCol = c;
        this.p = p;
        resources.add(new Food(p, this));
        resources.add(new Metal(p, this));
        resources.add(new Wealth(p, this));
        research = new Research(p);


        //This is for testing only

        //units.add(new FootMan(p, 500,500,0,this));
        units.add(new Workless(p, 0, 0, 0, this));
        units.add(new Workless(p, 0, 0, 0, this));
        units.add(new Workless(p, 0, 0, 0, this));
        //pStructures.add(new House(p,100,100));

    }


    public void draw() {

        this.update();

        if (pStructures != null) {
            for (Structure s : pStructures) {
                s.update();
                s.draw();
            }
        }
        if (units != null) {

            for (int i = units.size()-1; i >= 0; i--) {
                units.get(i).update();
                units.get(i).draw();

                if (units.get(i).checkIfDead() == true) {
                    killUnit(i);
                }
            }
        }
    }

    public void update() {
        this.updatePopMod(); //Gets the birthRate
        this.addToPopulation(); //Adds the birthRate to the current % complete
        this.createNewPop(); //checks and creates a new pop if newPop is at 100%
    }

    public int getPopulation() {
        if (units == null) return 0;
        return units.size();
    }

    public void addToPopulation() {
        if (this.getPopulation() >= popCap) return;
        newPop += popMod;

    }

    public void updatePopMod() {
        popMod = getPopulation()*baseMod;
    }

    public void createNewPop() {

        if (newPop >= 1) {
            newPop--;
            units.add(new Workless(p, 18, 18, 0, this)); //TODO change the create new pop to captial building position
        }
    }

    public void killUnit(int u) {
        units.remove(u);

    }
}
