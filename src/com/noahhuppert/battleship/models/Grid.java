package com.noahhuppert.battleship.models;

import java.util.ArrayList;

/**
 * Created by Noah Huppert on 12/2/2014.
 */
public class Grid {
    public static final int DEFAULT_GRID_SIZE_X = 10;
    public static final int DEFAULT_GRID_SIZE_Y = 10;

    private ArrayList<ArrayList<GridSquare>> gridSquares;

    private int sizeX;
    private int sizeY;

    public Grid(int sizeX, int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        reset();
    }

    /* Actions */
    public void reset(){
        setGridSquares(new ArrayList<ArrayList<GridSquare>>());

        for(int x = 0; x < sizeX; x++){
            ArrayList<GridSquare> gridSquaresY = new ArrayList<GridSquare>();

            for(int y = 0; y < sizeY; y++){
                gridSquaresY.add(y, new GridSquare());
            }
            gridSquares.add(x, gridSquaresY);
        }
    }

    private String drawDividingRow(boolean letters){
        String out = "";

        for(int y = 0; y < getSizeY(); y++) {
            if (letters) {
                out += "  ";

                if (y > 25) {
                    out += (char)('A' + (y - 25));
                } else {
                    out += (char)('A' + y);
                }

                out += " ";
            } else {
                out += " ---";
            }

            if(y == getSizeY(true)){
                out += "\n";
            }
        }

        return out;
    }

    private String drawDividingRow(){
        return drawDividingRow(false);
    }

    @Override
    public String toString(){
        String out = "";

        out += "   " + drawDividingRow(true);
        out += "   " + drawDividingRow();

        for(int x = 0; x <= getSizeX(true); x++){
            for(int y = 0; y <= getSizeY(true); y++){
                if(y == 0){
                    out += (x + 1);

                    if(x + 1 >= 10){
                        out += " ";
                    } else{
                        out += "  ";
                    }

                    out += "| ";
                }

                out += getGridSquareByXY(x, y) + " | ";

                if(y == getSizeY(true)){
                    out += "\n";
                }
            }
            out += "   " + drawDividingRow();
        }


        return out;
    }

    /* Getters */
    public ArrayList<ArrayList<GridSquare>> getGridSquares() {
        return gridSquares;
    }

    public GridSquare getGridSquareByXY(int x, int y){
        return getGridSquares().get(x).get(y);
    }

    public ArrayList<GridSquare> getGridSquareByX(int x){
        return getGridSquares().get(x);
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeX(boolean arrayFriendly){
        if(arrayFriendly){
            return getSizeX() - 1;
        }

        return getSizeX();
    }

    public int getSizeY() {
        return sizeY;
    }

    public int getSizeY(boolean arrayFriendly){
        if(arrayFriendly){
            return getSizeY() - 1;
        }

        return getSizeY();
    }

    /* Setters */
    public void setGridSquares(ArrayList<ArrayList<GridSquare>> gridSquares) {
        this.gridSquares = gridSquares;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }
}
