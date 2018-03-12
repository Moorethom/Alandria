package com.processing.sketch;

import processing.core.PApplet;

import java.awt.*;
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
        worldGen.draw();

        if (players == null) return;
        for (Player play : players) { //Main for loop for drawing the players
            play.draw();
        }
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