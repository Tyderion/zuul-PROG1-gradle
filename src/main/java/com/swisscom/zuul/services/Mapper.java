package com.swisscom.zuul.services;

import com.swisscom.zuul.Room;
import com.swisscom.zuul.components.Direction;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * Created by Archie on 04.10.2016.
 */
public class Mapper {

    private char[][] map = new char[3][3];

    public Mapper() {
        char[][] map1 = this.map;
        for (int i = 0; i < map1.length; i++) {
            char[] row = map1[i];
            for (int i1 = 0; i1 < row.length; i1++) {
                row[i1] = ' ';
            }
        }
    }

    public String mapStartingAt(Room startingRoom) {
        if (startingRoom == null) {
            return "";
        }
        this.map[1][1] = 'R';
        Arrays.stream(Direction.values()).forEach(dir -> {
            Room exit;
            switch (dir) {
                case EAST:
                    exit = startingRoom.getExit(dir);
                    if (exit != null) {

                    } else {
                        this.map[1][2] = 'W';
                    }
                case WEST:
                    exit = startingRoom.getExit(dir);
                    if (exit != null) {

                    } else {
                        this.map[1][0] = 'W';
                    }
                case NORTH:
                    exit = startingRoom.getExit(dir);
                    if (exit != null) {

                    } else {
                        this.map[0][1] = 'W';
                    }
                case SOUTH:
                    exit = startingRoom.getExit(dir);
                    if (exit != null) {

                    } else {
                        this.map[2][1] = 'W';
                    }
            }
        });
        StringBuilder map = new StringBuilder();
        for (char[] row : this.map) {
            for (char aRow : row) {
                map.append(aRow);
            }
            map.append('\n');
        }
        return map.toString();
    }

}
