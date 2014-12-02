package com.noahhuppert.battleship.models;

import java.util.ArrayList;

/**
 * Created by block7 on 12/2/14.
 */
public class Grid {
    private ArrayList<GridBox> gridBoxes;

    public Grid(){
        gridBoxes = new ArrayList<GridBox>();
    }

    public Grid(ArrayList<GridBox> gridBoxes){
        this.gridBoxes = gridBoxes;
    }

    public Grid(int size){
        gridBoxes = new ArrayList<GridBox>();

        for(int i = 0; i < size; i++){
            for(int ii = 0; ii < size; ii++)
            addGridBox(new GridBox(i, ii));
        }
    }

    /* Getters */
    public ArrayList<GridBox> getGridBoxes(){
        return gridBoxes;
    }

    public GridBox getGridBoxByPosition(Vector2 position){
        for(GridBox gridBox : getGridBoxes()){
            if(gridBox.getPosition().equals(position)){
                return gridBox;
            }
        }

        return null;
    }

    public GridBox getGridBoxByPosition(int x, int y){
        return getGridBoxByPosition(new Vector2(x, y));
    }

    /* Setters */
    public void setGridBoxes(ArrayList<GridBox> gridBoxes){
        this.gridBoxes = gridBoxes;
    }

    public void addGridBox(GridBox gridBox){
        getGridBoxes().add(gridBox);
    }
}
