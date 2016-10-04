package com.swisscom.zuul.components;

import java.util.Arrays;

/**
 * Created by Archie on 04.10.2016.
 */
public enum Direction {
    NORTH, EAST, SOUTH, WEST, UP, DOWN, UNKNOWN;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }

    public static Direction fromString(String cmd) {
        try {
            return Direction.valueOf(cmd);
        } catch (IllegalArgumentException e) {
            return Direction.UNKNOWN;
        }
    }

    /*
 * Print all valid commands to System.out.
 */
    public static void showAll() {
        Arrays.stream(Direction.values())
                .filter(direction -> direction != Direction.UNKNOWN)
                .forEach(direction -> System.out.print(direction + " "));
        System.out.println();
    }
}
