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
    public void testMapFromOriginalCode() {
        Room outside, theatre, pub, lab, office;

        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");

        // initialise room exits
        outside.setExit(Direction.EAST, theatre);
        outside.setExit(Direction.SOUTH, lab);
        outside.setExit(Direction.WEST, pub);

        theatre.setExit(Direction.WEST, outside);

        pub.setExit(Direction.EAST, outside);

        lab.setExit(Direction.NORTH, outside);
        lab.setExit(Direction.EAST, office);

        office.setExit(Direction.WEST, lab);

        outside.setVisited(true);
        pub.setVisited(true);
        theatre.setVisited(true);

        Mapper m = new Mapper();
        String map = m.mapStartingAt(outside);
//        assertEquals("WWW", map);
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