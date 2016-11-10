package edu.iit.cs445.usecases;

import edu.iit.cs445.database.Database;
import edu.iit.cs445.entitites.FarmerAccount;

import java.util.Map;

/**
 * Created by YongYang on 11/7/16.
 */
public class FarmerAccountManager {
    private Map<Long, FarmerAccount> farmerAccounts= Database.getFarmerAccounts();


}
