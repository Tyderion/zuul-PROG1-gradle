package com.swisscom.zuul.components;

/**
 * Created by tzhnaga1 on 24/10/16.
 */
public class Coordinate {
    public int x;
    public int y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
