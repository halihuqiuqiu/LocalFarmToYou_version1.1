package edu.iit.cs445.usecases;

import edu.iit.cs445.database.Database;
import edu.iit.cs445.database.Helper;
import edu.iit.cs445.entitites.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by YongYang on 11/19/16.
 */
public class MakeReportManagerForDeliveryTest {

    @Test
    public void makeReport() throws Exception {

        ReportManagerForDelivery report = MakeReportManagerForDelivery.makeReport("1");
        assertEquals("1", report.getMrid());
        assertEquals("Orders placed today", report.getName());

    }


}