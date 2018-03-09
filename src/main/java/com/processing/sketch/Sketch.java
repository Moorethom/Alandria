package com.processing.sketch;

import processing.core.PApplet;

public class Sketch extends PApplet {


    World world;
    AI ai; //This will probibly be a useless class so it can fuck off
    Hud hud;
    Camera camera;
    Mouse mouse;

    boolean keys[];
    int cameraSpeed;


    public void settings() {
        size(1280, 720, P2D);
        fullScreen();
    }


    public void setup() {
        frameRate(60);

        world = new World(this);
        camera = new Camera(this, width, height);
        mouse = new Mouse(this);

        world.setup();

        hud = new Hud(this, world.players.get(0), width, height);

        keys = new boolean[4];
        cameraSpeed = 3; //Speeds the camera moves

        text("hello",(width/2),(height/5));


    }


    public void draw() { //Main Draw function to call shit
        background(255);

        //Camera stuff
        pushMatrix(); //Opens Matrix
        updateCamera();
        translate(-camera.pos.x, -camera.pos.y);

        //World stuff
        world.draw();
        popMatrix(); //Closes Matrix

        //Hud stuff
        hud.update();
        hud.draw();

    }


    public static void main(String[] args) {
        PApplet.main("com.processing.sketch.Sketch", args);
    }



    //TODO This should be in a new key functions and add hot keys when I do this.
    public void keyPressed() {
        switch (key) {
            case 'w':
                keys[0] = true;
                break;
            case 'a':
                keys[1] = true;
                break;
            case 's':
                keys[2] = true;
                break;
            case 'd':
                keys[3] = true;
                break;
        }
    }


    public void keyReleased() {
        switch (key) {
            case 'w':
                keys[0] = false;
                break;
            case 'a':
                keys[1] = false;
                break;
            case 's':
                keys[2] = false;
                break;
            case 'd':
                keys[3] = false;
                break;
        }
    }


    void updateCamera() {
        if (keys[0] == true) camera.pos.y -= cameraSpeed;
        if (keys[1] == true) camera.pos.x -= cameraSpeed;
        if (keys[2] == true) camera.pos.y += cameraSpeed;
        if (keys[3] == true) camera.pos.x += cameraSpeed;
    }
}

