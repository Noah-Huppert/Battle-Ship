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
