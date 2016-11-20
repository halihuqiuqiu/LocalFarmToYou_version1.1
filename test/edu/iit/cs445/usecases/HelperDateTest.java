package edu.iit.cs445.usecases;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YongYang on 11/19/16.
 */
public class HelperDateTest {
    @Test
    public void getTodayDateyyyyMMdd() throws Exception {

        String today = HelperDate.getTodayDateyyyyMMdd();
        assertEquals(8,today.length());
    }

    @Test
    public void getTomorrowDateyyyyMMdd() throws Exception {

        String tomorrow = HelperDate.getTomorrowDateyyyyMMdd();
        assertEquals(8,tomorrow.length());
    }

}