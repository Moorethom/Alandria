package com.processing.sketch;

import processing.core.PApplet;

import java.util.ArrayList;

public class World {

    private final PApplet p;

    private int numberOfPlayers = 1;

    public ArrayList<Player> players = new ArrayList<Player>();

    WorldGen worldGen;
    int mapSize;


    public World(PApplet p) {
        this.p = p;
    }

    void setup() {

        mapSize = 32000/2; //This sets the map Size with 32,000 being small and 64,000 large, maybe add a smaller 16,000. The division of 2 is for the correct dimensions
        worldGen = new WorldGen(p, mapSize);

        worldGen.worldGeneration(); //Creates the world

        for(int i = 0; i<=numberOfPlayers; i++) { //This is the main for loop for creating the number of players in the game
            players.add(new Player(p, mapSize,i)); //This is for testing but is needed to setup at least one player
        }

        //p.rectMode(p.CENTER); //sets center if needed
    }

    void draw() {
        worldGen.draw(); //Draws the world created

        int count = 0; //Testing

        if (players == null) return;
        for (Player play : players) { //Main for loop for drawing the players
            p.fill(getColor(count)); //Testing
            play.draw();
            count++; //Testing
        }
    }

    public int getColor(int pTNumber){
        int pNumber = pTNumber;
        if(pNumber == 0)return p.color(255,0,0); //Red
        if(pNumber == 1)return p.color(0,0,255); //Blue
        if(pNumber == 2)return p.color(0,255,0); //Green
        if(pNumber == 3)return p.color(255,128,0); //Orange
        if(pNumber == 4)return p.color(0,255,255); //Cyan
        if(pNumber == 5)return p.color(255,255,0); //Yellow
        if(pNumber == 6)return p.color(255,0,128); //Pink
        if(pNumber == 7)return p.color(128,128,128); //Grey
        return 0;
    }

}

//add the world generation here

class WorldGen {

    PApplet p;

    private final int mapSize;
    private final int initialStart;

    public WorldGen(PApplet p, int mapSize) {
        this.p = p;
        this.mapSize = mapSize;
        initialStart = 0;
    }

    void worldGeneration(){

    }

    void draw(){
        p.fill(255);
        p.rect(initialStart,initialStart,mapSize,mapSize);
    }

}