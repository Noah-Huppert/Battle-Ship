package com.noahhuppert.battleship.models.players;

import com.noahhuppert.battleship.helpers.Log;
import com.noahhuppert.battleship.models.Grid;
import com.noahhuppert.battleship.models.HitStatus;

import java.util.ArrayList;

/**
 * Created by Noah Huppert on 12/2/2014.
 */
public class Player {
    private String name;
    private Grid selfGrid;
    private Grid guessGrid;

    public Player(){
        name = Log.readLine("What is your name?");
        selfGrid = new Grid(Grid.DEFAULT_GRID_SIZE_X, Grid.DEFAULT_GRID_SIZE_Y);
        guessGrid = new Grid(Grid.DEFAULT_GRID_SIZE_X, Grid.DEFAULT_GRID_SIZE_Y);
    }

    public Player(String name){
        this.name = name;
        selfGrid = new Grid(Grid.DEFAULT_GRID_SIZE_X, Grid.DEFAULT_GRID_SIZE_Y);
        guessGrid = new Grid(Grid.DEFAULT_GRID_SIZE_X, Grid.DEFAULT_GRID_SIZE_Y);
    }

    /* Actions */
    public String choose(){
        return "A1";
    }

    public void act(Player opponent){
        act(opponent, choose());
    }

    public String act(Player opponent, String choice){
        if(choice.length() < 2 && choice.length() > 3){
            Log.e("Player.act", "The player choice must contain a row in the form of a letter and a column in the form of a number");
            Log.d("Player.act", "Player choice invalid. Player choice => " + choice);
            return "Error: Invalid Choice";
        }

        ArrayList<Integer> quards = Grid.getXYFromString(choice);

        HitStatus hitStatus = opponent.getSelfGrid().getGridSquareByXY(quards.get(0), quards.get(1)).pick();
        getGuessGrid().getGridSquareByXY(quards.get(0), quards.get(1)).setHitStatus(hitStatus);

        return hitStatus.toString();
    }

    /* Getters */
    public String getName() {
        return name;
    }

    public Grid getSelfGrid() {
        return selfGrid;
    }

    public Grid getGuessGrid() {
        return guessGrid;
    }

    /* Setters */
    public void setName(String name) {
        this.name = name;
    }

    public void setSelfGrid(Grid selfGrid) {
        this.selfGrid = selfGrid;
    }

    public void setGuessGrid(Grid guessGrid) {
        this.guessGrid = guessGrid;
    }
}
