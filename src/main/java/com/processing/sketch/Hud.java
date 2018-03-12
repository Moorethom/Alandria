package com.processing.sketch;

import com.processing.sketch.Resources.Resource;
import processing.core.PApplet;
import processing.core.PFont;

import java.util.ArrayList;

public class Hud {

    private final PApplet p;
    PFont font;
    private int width;
    private int height;
    private double wealthTemp;
    private double metalTemp;
    private double foodTemp;

    private Player player;

    public boolean toggleResearch;
    public boolean toggleBuildings;
    //Building Tabs
    public boolean toggleBProductionTab;
    public boolean toggleBCivilianTab;
    public boolean toggleBMilitaryTab;

    //BuildingTypes
    public boolean toggleHouse;  //c
    public boolean toggleCapital;  //c
    public boolean toggleBarracks;  //m
    public boolean toggleFarm;  //p
    public boolean toggleUniversity;  //c
    public boolean toggleSchool; //c
    public boolean toggleMarket; //c
    public boolean toggleSmith; //p
    public boolean toggleEngineeringBay; //p
    public boolean toggleStable; //m
    public boolean toggleTrainingGround; //m
    public boolean toggleCityCenter; //c
    public boolean toggleMine; //p

    int widthDi;
    int heightDi;


    private ArrayList<Resource> resourcesTemp = new ArrayList<Resource>();  //0 = food, 1 = wealth, 2 = metal

    Hud(PApplet p, Player player, int width, int height) {
        this.p = p;
        this.width = width;
        this.height = height;
        this.player = player;
        this.resourcesTemp = player.resources;

        toggleBuildings = false;
        toggleResearch = false;

//        font = p.createFont("RobotoCondensed-Regular.ttf", 64, false);
        font = p.createFont("Arial", 64, false);

        widthDi = width / 10; //Commonly used width Dimension
        heightDi = height / 16; //Commonly used height Dimension
    }

    public void draw() {
        //p.rectMode(p.CORNER); //Sets CORNER mode if needed

        p.fill(255);

        p.rect(0, 0, width, heightDi);  // This draws the Hud frame

        //Draws the boxes for the height and research
        p.rect(0, 0, widthDi, heightDi);
        p.rect(width / 10, 0, widthDi, heightDi);

        if (toggleBuildings) {
            drawBuildingsTab();
            p.println("occur");
        } else if (toggleResearch) {
            drawResearchTab();
        } else if (toggleBMilitaryTab) {
            drawMilTab();
        } else if (toggleBCivilianTab) {
            drawCivTab();
        } else if (toggleBProductionTab) {
            drawProdTab();
        }


        //Sets and the font and colors
        p.textFont(font);
        p.textSize(32);

        p.pushMatrix();

        p.fill(0);
        //Draws the text for the research and buildings boxes
        p.text("Buildings", 32, height / 24);
        p.text("Research", 30 + widthDi, height / 24);

        //Sets the resource values for the specific associated resource
        p.text("Food: " + convertDouble(foodTemp), 32 + widthDi * 2, (height / 24));
        p.text("Wealth: " + convertDouble(wealthTemp), widthDi * 3, (height / 24));
        p.text("Metal: " + convertDouble(metalTemp), widthDi * 4, (height / 24));
        p.text("Pop: " + player.getPopulation(), widthDi * 5, (height / 24));

        p.popMatrix();
    }

    public void update() {
        foodTemp = resourcesTemp.get(0).getAmount();
        wealthTemp = resourcesTemp.get(1).getAmount();
        metalTemp = resourcesTemp.get(2).getAmount();
    }

    public String convertDouble(Double f) {
        return String.format("%.0f", f);
    }


    //Tab Drawings are here
    public void drawBuildingsTab() {
        p.fill(255);
        p.rect(0, heightDi, widthDi, heightDi); //Could use a for loop here but it might slow down the code for no real need
        p.rect(0, heightDi * 2, widthDi, heightDi);
        p.rect(0, heightDi * 3, widthDi, heightDi);

        p.fill(0);
        p.text("Production", 32, (heightDi) + 46);
        p.text("Civilian", 32, (heightDi * 2) + 46);
        p.text("Military", 32, (heightDi * 3) + 46);

    }

    public void drawResearchTab() {

    }

    public void drawMilTab() { //Miitary Tab Draws here
        p.fill(255);
        p.rect(0, heightDi, widthDi, heightDi);
        p.rect(0, heightDi * 2, widthDi, heightDi);
        p.rect(0, heightDi * 3, widthDi, heightDi);

        p.fill(0);
        p.text("Barracks", 32, (heightDi) + 46);
        p.text("Stable", 32, (heightDi * 2) + 46);
        p.text("Training", 32, (heightDi * 3) + 30);
        p.text("Ground", 32, (heightDi * 3) + 60);
    } //Draws the military Tab

    public void drawCivTab() { //Civilian Tab Draws here
        p.rect(0, heightDi, widthDi, heightDi);
        p.rect(0, heightDi * 2, widthDi, heightDi);
        p.rect(0, heightDi * 3, widthDi, heightDi);
        p.rect(0, heightDi * 4, widthDi, heightDi);
        p.rect(0, heightDi * 5, widthDi, heightDi);
        p.rect(0, heightDi * 6, widthDi, heightDi);

        p.fill(0);
        p.text("House", 32, (heightDi) + 46);
        p.text("Capital", 32, (heightDi * 2) + 46);
        p.text("University", 32, (heightDi * 3) + 46);
        p.text("School", 32, (heightDi * 4) + 46);
        p.text("Market", 32, (heightDi * 5) + 46);
        p.text("City", 32, (heightDi * 6) + 30);
        p.text("Center", 32, (heightDi * 6) + 60);
    } //Draws the Civilian Tab

    public void drawProdTab() { //Production Tab Draws here
        p.fill(255);
        p.rect(0, heightDi, widthDi, heightDi);
        p.rect(0, heightDi * 2, widthDi, heightDi);
        p.rect(0, heightDi * 3, widthDi, heightDi);
        p.rect(0, heightDi * 4, widthDi, heightDi);

        p.fill(0);
        p.text("Farm", 32, (heightDi) + 46);
        p.text("Smith", 32, (heightDi * 2) + 46);
        p.text("Engineering", 32, (heightDi * 3) + 30);
        p.text("Bay", 32, (heightDi * 3) + 60);
        p.text("Mine", 32, (heightDi * 4) + 46);
    } //Draws the Production Tab


    //Change Toggles are here
    public boolean flipToggle(boolean toggle) {
        return toggle ^= true;
    }

    //Hud
    public void toggleBuildings() {
        toggleBMilitaryTab = false;
        toggleBCivilianTab = false;
        toggleBProductionTab = false;

        toggleBuildings = flipToggle(toggleBuildings);
    }

    public void toggleResearch() {
        toggleResearch = flipToggle(toggleResearch);
    }

    //Tabs
    public void militaryTab() {
        toggleBMilitaryTab = flipToggle(toggleBMilitaryTab);
        toggleBuildings = flipToggle(toggleBuildings);
    }

    public void productionTab() {
        toggleBProductionTab = flipToggle(toggleBProductionTab);
        toggleBuildings = flipToggle(toggleBuildings);
    }

    public void civilianTab() {
        toggleBCivilianTab = flipToggle(toggleBCivilianTab);
        toggleBuildings = flipToggle(toggleBuildings);
    }

    //BuildingTypes
    public void tHouse() {
        toggleHouse = flipToggle(toggleHouse);
        toggleBCivilianTab = flipToggle(toggleBCivilianTab);
    }

    public void tCapital() {
        toggleCapital = flipToggle(toggleCapital);
        toggleBCivilianTab = flipToggle(toggleBCivilianTab);
    }

    public void tBarracks() {
        toggleBarracks = flipToggle(toggleBarracks);
        toggleBMilitaryTab = flipToggle(toggleBMilitaryTab);
    }

    public void tFarm() {
        toggleFarm = flipToggle(toggleFarm);
        toggleBProductionTab = flipToggle(toggleBProductionTab);
    }

    public void tUniversity() {
        toggleUniversity = flipToggle(toggleUniversity);
        toggleBCivilianTab = flipToggle(toggleBCivilianTab);
    }

    public void tSchool() {
        toggleSchool = flipToggle(toggleSchool);
        toggleBCivilianTab = flipToggle(toggleBCivilianTab);
    }

    public void tMarket() {
        toggleMarket = flipToggle(toggleMarket);
        toggleBCivilianTab = flipToggle(toggleBCivilianTab);
    }

    public void tSmith() {
        toggleSmith = flipToggle(toggleSmith);
        toggleBProductionTab = flipToggle(toggleBProductionTab);
    }

    public void tEngineeringBay() {
        toggleEngineeringBay = flipToggle(toggleEngineeringBay);
        toggleBProductionTab = flipToggle(toggleBProductionTab);
    }

    public void tStable() {
        toggleStable = flipToggle(toggleStable);
        toggleBMilitaryTab = flipToggle(toggleBMilitaryTab);
    }

    public void tTrainingGround() {
        toggleTrainingGround = flipToggle(toggleTrainingGround);
        toggleBMilitaryTab = flipToggle(toggleBMilitaryTab);
    }

    public void tCityCenter() {
        toggleCityCenter = flipToggle(toggleCityCenter);
        toggleBCivilianTab = flipToggle(toggleBCivilianTab);
    }

    public void tMine() {
        toggleMine = flipToggle(toggleMine);
        toggleBProductionTab = flipToggle(toggleBProductionTab);
    }

}
