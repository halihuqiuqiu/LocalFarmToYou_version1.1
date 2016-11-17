package edu.iit.cs445.usecases;

import edu.iit.cs445.database.Database;
import edu.iit.cs445.entitites.Catalog;
import edu.iit.cs445.entitites.Manager;
import edu.iit.cs445.exception.DataNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YongYang on 11/16/16.
 */
public class MangerService {
    private static Map<String, Manager> managerMap = Database.getManagerMap();

    public List<Manager> getAllManagers() {

        return new ArrayList<Manager>(managerMap.values());
    }

    public Manager getManagerById(String mid) {
        Manager manager = managerMap.get(mid);
        if(manager==null){
            throw new DataNotFoundException();
        }
        return manager;
    }

}
