package edu.iit.cs445.entitites;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by YongYang on 11/19/16.
 */
public class ManagerTest {

    @Test
    public void returnAllKindReports() throws Exception {

        List<ReportManager> reportManagerList = Manager.returnAllKindReports();
        assertEquals(5, reportManagerList.size());
        assertEquals("1",reportManagerList.get(0).getMrid());
        assertEquals("Orders placed today", reportManagerList.get(0).getName());
    }

}