package com.noahhuppert.battleship.models;

/**
 * Created by block7 on 12/2/14.
 */
public class GridBox {
    /* Constants */
    public static final String HIT_STATUS_NONE = "HIT_STATUS_NONE";
    public static final String HIT_STATUS_HIT = "HIT_STATUS_HIT";
    public static final String HIT_STATUS_MISS = "HIT_STATUS_MISS";

    public static final String HIT_STATUS_MARKER_NONE = "o";
    public static final String HIT_STATUS_MARKER_HIT = "x";
    public static final String HIT_STATUS_MARKER_MISS = "-";

    private Vector2 position;
    private String hitStatus;

    public GridBox(Vector2 position){
        this.position = position;
        this.hitStatus = HIT_STATUS_NONE;
    }

    public GridBox(int x, int y){
        this.position = new Vector2(x, y);
        this.hitStatus = HIT_STATUS_NONE;
    }

    /* Actions */
    //TODO Make toString based on hit markers

    /* Getters */
    public Vector2 getPosition() {
        return position;
    }

    public String getHitStatus() {
        return hitStatus;
    }

    /* Setters */
    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setHitStatus(String hitStatus) {
        this.hitStatus = hitStatus;
    }
}
