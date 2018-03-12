package com.processing.sketch;

import processing.core.PApplet;

public class Mouse {

    PApplet p;
    private Hud hudTemp;

    private int heightTemp;
    private int widthTemp;
    private int mouseY;
    private int mouseX;

    private int heightDi;
    private int widthDi;

    public Mouse(PApplet p) {
        this.p = p;
    }


    void mouseColl(int mouseXPos, int mouseYPos, Hud hud, int width, int height) {

        this.hudTemp = hud;

        this.widthTemp = width;
        this.heightTemp = height;
        this.mouseX = mouseXPos;
        this.mouseY = mouseYPos;

        heightDi = heightTemp/16; //Commonly Used height variable
        widthDi = widthTemp/10; //Commonly Used Width variable

        //HUD stuff here
        if (mouseY <= heightTemp / 16) { //if the mouse is clicked in the Top hud

            if (mouseX > 0 && mouseX <= widthDi) {  //This is for checking when no tabs are open
                hudTemp.toggleBuildings(); //Turns the display on/off for the Buildings box
                //p.println("Buildings"); //Testing

            } else if (mouseX > widthDi && mouseX <= widthDi * 2) {
                hudTemp.toggleResearch(); //Turns the display on/off for the Research box
                //p.println("Research"); //Testing
            }
        } else if (mouseX > 0 && mouseX <= widthDi) { //This is for an open building Tab
            if(hudTemp.toggleBuildings){ //Checks if the building Hud is open

                if(mouseY > heightDi && mouseY <= heightDi*2){ //Production tab check
                    hudTemp.productionTab();
                } else if (mouseY > heightDi*2 && mouseY <= heightDi*3) {
                    hudTemp.civilianTab();
                } else if (mouseY > heightDi*3 && mouseY <= heightDi*4) {
                    hudTemp.militaryTab();
                }

            } else if (hudTemp.toggleBMilitaryTab){ //Military Tab is open
                if(mouseY > heightDi && mouseY <= heightDi*2){
                    hudTemp.tBarracks();
                } else if (mouseY > heightDi*2 && mouseY <= heightDi*3) {
                    hudTemp.tStable();
                } else if (mouseY > heightDi*3 && mouseY <= heightDi*4) {
                    hudTemp.tTrainingGround();
                }

            } else if (hudTemp.toggleBCivilianTab){ //Civilian Tab is open
                if(mouseY > heightDi && mouseY <= heightDi*2){
                    hudTemp.tHouse();
                } else if (mouseY > heightDi*2 && mouseY <= heightDi*3) {
                    hudTemp.tCapital();
                } else if (mouseY > heightDi*3 && mouseY <= heightDi*4) {
                    hudTemp.tUniversity();
                } else if (mouseY > heightDi*4 && mouseY <= heightDi*5) {
                    hudTemp.tSchool();
                } else if (mouseY > heightDi*5 && mouseY <= heightDi*6) {
                    hudTemp.tMarket();
                } else if (mouseY > heightDi*6 && mouseY <= heightDi*7) {
                    hudTemp.tCityCenter();
                }

            } else if (hudTemp.toggleBProductionTab){ //Production Tab is open
                if(mouseY > heightDi && mouseY <= heightDi*2){
                    hudTemp.tFarm();
                } else if (mouseY > heightDi*2 && mouseY <= heightDi*3) {
                    hudTemp.tSmith();
                } else if (mouseY > heightDi*3 && mouseY <= heightDi*4) {
                    hudTemp.tEngineeringBay();
                } else if (mouseY > heightDi*4 && mouseY <= heightDi*5) {
                    hudTemp.tMine();
                }

            }
        } //else if (){ //Checking if a building or unit is clicked on here

    }
}
