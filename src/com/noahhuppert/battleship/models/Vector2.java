package com.noahhuppert.battleship.models;

/**
 * Created by block7 on 12/2/14.
 */
public class Vector2 {
    private int x;
    private int y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /* Actions */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector2)) return false;

        Vector2 vector2 = (Vector2) o;

        if (x != vector2.x) return false;
        if (y != vector2.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    /* Getters */
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /* Setters */
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
