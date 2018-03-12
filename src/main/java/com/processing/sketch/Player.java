package com.processing.sketch;

import com.processing.sketch.Resources.*;
import com.processing.sketch.Structures.Capital;
import com.processing.sketch.Structures.Structure;
import com.processing.sketch.Units.CivUnits.Workless;
import com.processing.sketch.Units.Unit;
import processing.core.PApplet;
import processing.core.PVector;

import java.awt.*;
import java.util.ArrayList;

public class Player {


    public final PApplet p;

    public ArrayList<Structure> pStructures = new ArrayList<Structure>();
    public ArrayList<Unit> units = new ArrayList<Unit>();
    public ArrayList<Resource> resources = new ArrayList<Resource>();
    public Research research;

    private int popCap = 300; //The population the sigmoid function aims to reach (Use to increase Pop)
    private double baseMod = 0.00006; //The rate of growth (Use to increase the rate of growth or decrease)
    private double popMod = 0; //This is the value gained from the sigmoid function

    private double newPop = 0; //1 = new pop

    public double deathTime = 0.0002; //The rate at which units age

    public int mapSize;
    public int pNumber;

    public int startingXPos;
    public int startingYPos;


    public Player(PApplet p,  int mapSize, int pNumber) {
        this.p = p;
        this.mapSize = mapSize;
        this.pNumber = pNumber;
        resources.add(new Food(p, this));
        resources.add(new Wealth(p, this));
        resources.add(new Metal(p, this));
        research = new Research(p);

        startingXPos = getStartingXPos(this.pNumber);
        startingYPos = getStartingYPos(this.pNumber);
        pStructures.add(new Capital(this.p,startingXPos , startingYPos));


        //This is for testing only

        //units.add(new FootMan(p, 500,500,0,this));
        units.add(new Workless(p, startingXPos+234, startingYPos+100,this));
        units.add(new Workless(p, startingXPos-50, startingYPos+100,this));
        units.add(new Workless(p, startingXPos+92, startingYPos+250,this));
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
            for (int i = units.size() - 1; i >= 0; i--) {
                Unit currentUnit = units.get(i);
                currentUnit.update();
                currentUnit.draw();
                if (units.get(i).checkIfDead()) {
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
        popMod = (getPopulation() * baseMod) * (1 - (getPopulation() / popCap)); //This models the sigmoid function to add to the population
    }

    public void createNewPop() {
        if (newPop >= 1) {
            newPop--;
            units.add(new Workless(p, 18, 18,this)); //TODO change the create new pop to captial building position
        }
    }

    public void killUnit(int i) {
        units.remove(i);
    }

    public int getStartingXPos(int pNumber) {
        int tempInt = 0;
        int tempPNumber = pNumber;

        if (tempPNumber == 0) { //P1
            return mapSize / 16;
        } else if (tempPNumber == 1) { //P2
            return mapSize - (mapSize / 16);
        } else if (tempPNumber == 2) { //P3
            return mapSize / 16;
        } else if (tempPNumber == 3) { //P4
            return mapSize - (mapSize / 16);
        } else if (tempPNumber == 4) { //P5
            return mapSize / 2;
        } else if (tempPNumber == 5) { //P6
            return mapSize / 16;
        } else if (tempPNumber == 6) { //P7
            return mapSize / 2;
        } else if (tempPNumber == 7) { //P8
            return mapSize - (mapSize / 16);
        }

        return tempInt;
    }

    private int getStartingYPos(int pNumber) {
        int tempInt = 0;
        int tempPNumber = pNumber;

        if (tempPNumber == 0) { //P1
            return mapSize / 16;
        } else if (tempPNumber == 1) { //P2
            return mapSize - (mapSize / 16);
        } else if (tempPNumber == 2) { //P3
            return mapSize - (mapSize / 16);
        } else if (tempPNumber == 3) { //P4
            return mapSize / 16;
        } else if (tempPNumber == 4) { //P5
            return mapSize / 2;
        } else if (tempPNumber == 5) { //P6
            return mapSize / 16;
        } else if (tempPNumber == 6) { //P7
            return mapSize - (mapSize / 16);
        } else if (tempPNumber == 7) { //P8
            return mapSize / 2;
        }
        return tempInt;
    }
}
