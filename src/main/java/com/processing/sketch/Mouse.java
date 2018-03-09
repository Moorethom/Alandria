package com.processing.sketch;

import processing.core.PApplet;

public class Mouse {

    PApplet p;
    private Hud hudTemp;

    private int heightTemp;
    private int widthTemp;
    private int mouseY;
    private int mouseX;

    public Mouse(PApplet p) {
        this.p = p;
    }


    void mouseColl(int mouseXPos, int mouseYPos, Hud hud, int width, int height) {

        this.hudTemp = hud;

        this.widthTemp = width;
        this.heightTemp = height;
        this.mouseX = mouseXPos;
        this.mouseY = mouseYPos;

        if (mouseY <= heightTemp/16){ //if the mouse is clicked in the hud

            if (mouseX > 0 && mouseX <= widthTemp/10) { //first tool
                hudTemp.toggleBuildings(); //Turns the display on/off for the Buildings box
                //p.println("Buildings"); //Testing

            } else if (mouseX > widthTemp/10 && mouseX <= (widthTemp/10)*2){ //2nd tool
                hudTemp.toggleResearch(); //Turns the display on/off for the Research box
                //p.println("Research"); //Testing
            }
        }
    }
}
