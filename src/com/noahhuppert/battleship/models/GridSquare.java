package com.noahhuppert.battleship.models;

import com.noahhuppert.battleship.helpers.Log;

import java.util.ArrayList;

/**
 * Created by Noah Huppert on 12/2/2014.
 */
public class GridSquare {
    private HitStatus hitStatus;
    private Ship ship = null;

    public GridSquare(){
        this.hitStatus = HitStatus.NONE;
        ship = null;
    }

    /* Actions */
    public HitStatus pick(){
        if(getShip() != null){
            boolean shipDestroyed = getShip().hit();


            if(shipDestroyed) {
                setShip(null);
                Log.i("Ship sunk!");
            }

            setHitStatus(HitStatus.HIT);
            return HitStatus.HIT;
        }

        return HitStatus.MISS;
    }

    @Override
    public String toString(){
        if(getHitStatus() == HitStatus.HIT){
            return "x";
        } else if(getHitStatus() == HitStatus.MISS) {
            return "o";
        } else if(getHitStatus() == HitStatus.NONE && getShip() != null) {
            return "b";
        } else {
            return "~";
        }
    }

    /* Getters */
    public HitStatus getHitStatus() {
        return hitStatus;
    }

    public Ship getShip() {
        return ship;
    }

    /* Setters */
    public void setHitStatus(HitStatus hitStatus) {
        this.hitStatus = hitStatus;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
