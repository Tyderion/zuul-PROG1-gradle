package com.swisscom.zuul.services;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Archie on 04.10.2016.
 */
public class MapperTest {

    @Test
    public void testPrintMapFromRoomSize5() {
        Mapper m = new Mapper(5);
        String map = m.mapStartingAt(null);

        assertEquals("-----------\n" +
                "|         |\n" +
                "|         |\n" +
                "|         |\n" +
                "|         |\n" +
                "|         |\n" +
                "|         |\n" +
                "|         |\n" +
                "|         |\n" +
                "|         |\n" +
                "-----------", map);
    }

    @Test
    public void testPrintMapFromRoomSize3() {
        Mapper m = new Mapper(3);
        String map = m.mapStartingAt(null);

        assertEquals("-------\n" +
                "|     |\n" +
                "|     |\n" +
                "|     |\n" +
                "|     |\n" +
                "|     |\n" +
                "-------", map);
    }

}