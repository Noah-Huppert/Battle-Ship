package com.noahhuppert.battleship.models;

import java.util.ArrayList;

/**
 * Created by block7 on 12/2/14.
 */
public class Ship {
    private String name;
    private ArrayList<GridBox> gridBoxes;

    public Ship(String name){
        this.name = name;
        gridBoxes = new ArrayList<GridBox>();
    }

    /* Actions */
    public boolean isIn(GridBox gridBox){
        return getGridBoxes().contains(gridBox);
    }

    /* Getters */
    public String getName() {
        return name;
    }

    public ArrayList<GridBox> getGridBoxes() {
        return gridBoxes;
    }

    public GridBox getGridBoxByIndex(int index){
        return getGridBoxes().get(index);
    }

    /* Setters */
    public void setName(String name) {
        this.name = name;
    }

    public void setGridBoxes(ArrayList<GridBox> gridBoxes) {
        this.gridBoxes = gridBoxes;
    }
}
