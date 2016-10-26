package com.swisscom.zuul.services;

import com.swisscom.zuul.Room;
import com.swisscom.zuul.components.Direction;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Archie on 04.10.2016.
 */
public class MapperTest {

    @Test
    public void testEmptyMap() {
        Mapper m = new Mapper();
        String map = m.mapStartingAt(null);

        assertEquals("", map);
    }

    @Test
    public void testMapSingleRoom() {
        Mapper m = new Mapper();
        Room room = new Room("Irrelevant");
        room.setVisited(true);
        String map = m.mapStartingAt(room);

        assertEquals("WWW\n" +
                "WRW\n" +
                "WWW", map);
    }

    @Test
    public void testMapTwoRoomsWest() {
        Mapper m = new Mapper();
        Room room = new Room("Irrelevant");
        room.setVisited(true);
        Room second = new Room("Irrelevant again");
        room.setExit(Direction.WEST, second);
        String map = m.mapStartingAt(room);

        assertEquals("WWW\n" +
                "?RW\n" +
                "WWW", map);
    }

    @Test
    public void testMapThreeRoomsWestEastRecursive() {
        Mapper m = new Mapper();
        Room room = new Room("Irrelevant");
        room.setVisited(true);
        Room second = new Room("Irrelevant again");
        second.setVisited(true);
        room.setExit(Direction.WEST, second);
        second.setExit(Direction.EAST, room);
        String map = m.mapStartingAt(room);

        assertEquals("WWW\n" +
                "RRW\n" +
                "WWW", map);
    }

    @Test
    public void testMapThreeRoomsWestEast() {
        Mapper m = new Mapper();
        Room room = new Room("Irrelevant");
        room.setVisited(true);
        Room second = new Room("Irrelevant again");
        Room third = new Room("still irrelevant");
        room.setExit(Direction.WEST, second);
        room.setExit(Direction.EAST, third);
        String map = m.mapStartingAt(room);

        assertEquals("WWW\n" +
                "?R?\n" +
                "WWW", map);
    }

    @Test
    public void testMapThreeRoomsWestWestFirstVisited() {
        Mapper m = new Mapper();
        Room room = new Room("Irrelevant");
        room.setVisited(true);
        Room second = new Room("Irrelevant again");
        Room third = new Room("still irrelevant");
        room.setExit(Direction.WEST, second);
        second.setExit(Direction.WEST, third);
        String map = m.mapStartingAt(room);

        assertEquals("WWW\n" +
                "?RW\n" +
                "WWW", map);
    }
}