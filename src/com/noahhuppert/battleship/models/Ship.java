package com.noahhuppert.battleship.models;

/**
 * Created by Noah Huppert on 12/2/2014.
 */
public class Ship {
    private int size;

    public Ship(int size){
        this.size = size;
    }

    /* Actions */

    /**
     * Takes one size off the ship
     * @return True if the ship is sunk and false if it is not
     */
    public boolean hit(){
        setSize(getSize() - 1);
        return getSize() <= 0;
    }

    /* Getters */
    public int getSize(){
        return size;
    }

    /* Setters */
    public void setSize(int size){
        this.size = size;
    }
}
