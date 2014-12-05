package com.noahhuppert.battleship.models;

import java.util.ArrayList;

/**
 * Created by Noah Huppert on 12/2/2014.
 */
public class Grid {
    public static final int DEFAULT_GRID_SIZE_X = 10;
    public static final int DEFAULT_GRID_SIZE_Y = 10;
    public static final String DEFAULT_SPACER = "   ";

    private ArrayList<ArrayList<GridSquare>> gridSquares;

    private int sizeX;
    private int sizeY;

    public Grid(int sizeX, int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        reset();
    }

    /* Actions */
    public static ArrayList<Integer> getXYFromString(String string){
        int row = Integer.parseInt(string.substring(1)) - 1;
        int column = Character.toUpperCase(string.charAt(0)) - 'A';

        ArrayList<Integer> out = new ArrayList<Integer>();
        out.add(row);
        out.add(column);

        return out;
    }

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

    private String drawDividingRow(){
        String out = "";

        for(int y = 0; y < getSizeY(); y++){
            out += (char)('A' + y);
            out += DEFAULT_SPACER;
        }

        out += "\n";
        return out;
        /*String out = "    ";

        for(int y = 0; y < getSizeY(); y++) {
            out += " ";

            if (y > 25) {
                out += (char)('A' + (y - 25));
            } else {
                out += (char)('A' + y);
            }

            out += "  ";

            if(y == getSizeY(true)){
                out += "\n";
            }
        }

        return out;*/
    }

    @Override
    public String toString(){
        String out = "";

        out += "       " + drawDividingRow();

        for(int x = 0; x <= getSizeX(true); x++){
            for(int y = 0; y <= getSizeY(true); y++){
                if(y == 0){
                    out += x + 1;

                    if(x < 9){
                        out += "  ";
                    }

                    out += DEFAULT_SPACER;
                }

                out += getGridSquareByXY(x, y);
                out += DEFAULT_SPACER;
            }

            out += "\n";
        }

        return out;
        /*String out = "";

        out += "   " + drawDividingRow();

        for(int x = 0; x <= getSizeX(true); x++){
            for(int y = 0; y <= getSizeY(true); y++){
                if(y == 0){
                    out += (x + 1);

                    if(x + 1 >= 10){
                        out += " ";
                    } else{
                        out += "   ";
                    }

                    out += "   ";
                }

                out += getGridSquareByXY(x, y) + "   ";

                if(y == getSizeY(true)){
                    out += "\n";
                }
            }
        }


        return out;*/
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
