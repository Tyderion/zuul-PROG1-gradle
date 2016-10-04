package com.swisscom.zuul.services;

import com.swisscom.zuul.Room;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Archie on 04.10.2016.
 */
public class Mapper {
    private int gridSize = 5;

    public Mapper(int gridSize) {
        this.gridSize = gridSize;
    }

    public String mapStartingAt(Room startingRoom) {
        return this.getGrid();
    }

    private String getHeader() {
        return "-" + StringUtils.repeat("-", this.gridSize * 2 - 1) + "-";
    }

    private String getEmptyLine() {
        return "|" + StringUtils.repeat(" ", this.gridSize * 2 - 1) + "|";
    }

    private String getGrid() {
        return this.getHeader() + "\n" + StringUtils.repeat(this.getEmptyLine() + "\n", this.gridSize * 2 - 1) + getHeader();
    }
}
