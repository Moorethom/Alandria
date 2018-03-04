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
    public double deathTime = 0.002; //The rate at which units age

    private double newPop = 0; //1 = new pop

    public Color playerCol; //Player color


    //Test variables
    private int count = 0;
    private int count2 = 0;


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
            //Fields
            int count = 0;
            int killUnits = -1;

            for (Unit u : units) {
                u.update();
                u.draw();
                if (u.checkIfDead() == true) {
                    killUnits = count-units.size();
                    u.newCol();
                }
                count++;
            }
            if(killUnits < 0)return;
            killUnit(count);
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
        p.println(newPop);
    }

    public void createNewPop() {

        if (newPop >= 1) { //Counts can be removed
            count++;
            newPop--;
            if (count * 18 > 1920) {
                count = 0;
                count2++;
            }
            units.add(new Workless(p, count * 18, count2 * 18 + 18, 0, this)); //TODO change the create new pop to captial building position
        }
    }

    public void killUnit(int u) {
        //units.remove(u); //TODO un comment this to fix it
    }
}
