package edu.iit.cs445.database;

import edu.iit.cs445.entitites.Manager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by YongYang on 11/19/16.
 */
public class HelperTest {
    private Map<String, Manager> managerMap = Helper.getManagerMapWithSystemManager();

    @Test
    public void getManagerMapWithSystemManager() throws Exception {

        assertEquals(1,managerMap.size());
        assertEquals(managerMap.get("0").getName(),"Super User");
    }

}