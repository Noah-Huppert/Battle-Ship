package com.noahhuppert.battleship.views;

import com.noahhuppert.battleship.models.Grid;
import com.noahhuppert.battleship.models.GridBox;

/**
 * Created by block7 on 12/2/14.
 */
public class AsciiGridView {
    private Grid grid;

    public AsciiGridView(Grid grid){
        this.grid = grid;
    }

    public AsciiGridView(int size){
        this.grid = new Grid(size);
    }

    /* Actions */
    public void draw(){
        String out = "";

        for(int i = 0; i < getGrid().getGridBoxes().size(); i++){
            for(int ii = 0; ii < getGrid().getGridBoxes().size(); ii++){
                out += getGrid().getGridBoxByPosition(i, ii).toString();
            }
        }

        //TODO Make rest of this method
    }

    /* Getters */
    public Grid getGrid(){
        return grid;
    }

    /* Setters */
    public void setGrid(Grid grid){
        this.grid = grid;
    }
}
