package edu.iit.cs445.usecases;

import edu.iit.cs445.database.Database;
import edu.iit.cs445.entitites.Customer;
import edu.iit.cs445.entitites.FarmerAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by YongYang on 11/7/16.
 */
public class FarmerAccountManager {
    private Map<Long, FarmerAccount> farmerAccounts= Database.getFarmerAccounts();
    public List<FarmerAccount> getAllFarmerAccounts() {

        return new ArrayList<FarmerAccount>(farmerAccounts.values());
    }

    public FarmerAccount addFarmerAccount(FarmerAccount farmerAccount) {
        farmerAccount.setFid(farmerAccounts.size()+1);
        farmerAccounts.put(farmerAccount.getFid(),farmerAccount);
        return farmerAccount;
    }


}
