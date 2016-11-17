package edu.iit.cs445.database;

import edu.iit.cs445.entitites.Manager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YongYang on 11/16/16.
 */
public class Helper {


    public static Map<String, Manager> getManagerMapWithSystemManager(){
        Map<String, Manager> managerMap = new HashMap<String, Manager>();
        Manager managerSuper = new Manager("0","Super User","System","20161001","123-0987-654","superuser@example.com");
        managerMap.put("0", managerSuper);
        return managerMap;
    }
}
