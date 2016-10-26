package com.swisscom.zuul.components;

import com.swisscom.zuul.services.Mapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by tzhnaga1 on 25/10/16.
 */
public class DirectionTest {
    @Test
    public void testValueOfWest() {
        Direction dir = Direction.fromString("west");
        assertEquals(Direction.WEST, dir);
    }

}
