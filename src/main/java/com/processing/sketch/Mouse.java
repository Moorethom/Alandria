package com.processing.sketch;

import processing.core.PApplet;

public class Mouse {

    PApplet p;

    public Mouse(PApplet p) {
        this.p = p;
    }


    void mouseColl(int mouseXPos, int mouseYPos) {
        if (mouseXPos <= 80) { //if the mouse is clicked in the hud
            /*

            if (mouseYPos > 0 && mouseYPos <= 45) { //first tool
                toggleBuildings = true;
                //println("Buildings");
            } else if (mouseYPos > 45 && mouseYPos <= 90) { //2nd tool
                tool.update(2); //forward
                //println("Research");
            }

            */
        }
    }
}
