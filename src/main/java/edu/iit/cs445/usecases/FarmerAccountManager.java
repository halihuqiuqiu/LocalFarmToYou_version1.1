package edu.iit.cs445.usecases;

import edu.iit.cs445.database.Database;
import edu.iit.cs445.entitites.*;
import edu.iit.cs445.exception.BadRequestException;
import edu.iit.cs445.exception.DataNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YongYang on 11/7/16.
 */
public class FarmerAccountManager {
    private Map<String, FarmerAccount> farmerAccounts= Database.getFarmerAccounts();
    public List<FarmerAccount> getAllFarmerAccounts() {

        return new ArrayList<FarmerAccount>(farmerAccounts.values());
    }

    public FarmerAccount addFarmerAccount(FarmerAccount farmerAccount) {
        farmerAccount.setFid(String.valueOf(farmerAccounts.size()+1));
        farmerAccount.setName(farmerAccount.getPersonal_info().getName());
        farmerAccounts.put(farmerAccount.getFid(),farmerAccount);
        return farmerAccount;
    }

    public FarmerAccount getFarmerAccountById(String fid) {
        FarmerAccount farmerAccount = farmerAccounts.get(fid);
        if(farmerAccount==null){
            throw new DataNotFoundException();
        }
        return farmerAccount;
    }

    public FarmerAccount updateFarmerAccount(FarmerAccount farmerAccount) {
        String fid=farmerAccount.getFid();
        if(farmerAccounts.get(fid)==null){
            throw new DataNotFoundException();
        }
        farmerAccount.setName(farmerAccount.getPersonal_info().getName());
        farmerAccounts.put(farmerAccount.getFid(), farmerAccount);
        return farmerAccount;
    }

    public List<FarmerAccount> findFarmerAccountByZip(String zip){
        List<FarmerAccount> result = new ArrayList<FarmerAccount>();
        List<FarmerAccount> farmerAccountsList= getAllFarmerAccounts();
        for(FarmerAccount farmerAccount: farmerAccountsList){
            for(String s : farmerAccount.getDelivers_to()){
                if (s.equals(zip)){
                    result.add(farmerAccount);
                }
            }
        }
        return result;
    }

}
