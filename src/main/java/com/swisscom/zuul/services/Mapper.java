package com.swisscom.zuul.services;

import com.swisscom.zuul.Room;
import com.swisscom.zuul.components.Coordinate;
import com.swisscom.zuul.components.Direction;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * Created by Archie on 04.10.2016.
 */
public class Mapper {

    private char[][] map = new char[3][3];

    public Mapper() {
        init();
    }

    private void init() {
        this.map =  new char[3][3];
        char[][] map1 = this.map;
        for (int i = 0; i < map1.length; i++) {
            char[] row = map1[i];
            for (int i1 = 0; i1 < row.length; i1++) {
                row[i1] = 'W';
            }
        }
    }


    private void drawMap(Room room, Coordinate current) {
        if (!room.isVisited() || (this.map[current.x][current.y] != 'W'
                && this.map[current.x][current.y] != '?')) {
            return;
        }
        this.map[current.x][current.y] = 'R';
        Arrays.stream(Direction.values()).forEach(dir -> {
            Room exit = room.getExit(dir);
            if (exit != null) {
                switch (dir) {
                    case EAST:
                        if (exit.isVisited()) {
                            drawMap(exit, new Coordinate(current.x, current.y + 1));
                        } else {
                            this.map[current.x][current.y + 1] = '?';
                        }
                        break;
                    case WEST:
                        if (exit.isVisited()) {
                            drawMap(exit, new Coordinate(current.x, current.y - 1));
                        } else {
                            this.map[current.x][current.y - 1] = '?';
                        }
                        break;
                    case NORTH:
                        if (exit.isVisited()) {
                            drawMap(exit, new Coordinate(current.x - 1, current.y));
                        } else {
                            this.map[current.x - 1][current.y] = '?';
                        }
                        break;
                    case SOUTH:
                        if (exit.isVisited()) {
                            drawMap(exit, new Coordinate(current.x + 1, current.y));
                        } else {
                            this.map[current.x + 1][current.y] = '?';
                        }
                        break;

                }
            }
        });
    }
    public String mapStartingAt(Room startingRoom) {
        if (startingRoom == null) {
            return "";
        }

        init();
        this.drawMap(startingRoom, new Coordinate(1, 1));

        StringBuilder map = new StringBuilder();
        for (char[] row : this.map) {
            for (char aRow : row) {
                map.append(aRow);
            }
            map.append('\n');
        }
        return map.toString().trim();
    }

}
