package edu.iit.cs445.usecases;

import edu.iit.cs445.database.Database;
import edu.iit.cs445.database.Helper;
import edu.iit.cs445.entitites.*;
import edu.iit.cs445.exception.DataNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by YongYang on 11/19/16.
 */
public class FarmerAccountManagerTest {

    private FarmerAccountManager fam = new FarmerAccountManager();

    private Farmer farmer1= new Farmer();
    private Farmer farmer2= new Farmer();
    private FarmerAccount farmerAccount1 = new FarmerAccount();
    private FarmerAccount farmerAccount2 = new FarmerAccount();

    @Before
    public void setup(){
        Database.setCustomers(new HashMap<String, Customer>());
        Database.setCatalogs(new HashMap<String, Catalog>());
        Database.setFarmerAccounts(new HashMap<String, FarmerAccount>());
        Database.setManagerMap(Helper.getManagerMapWithSystemManager());
        Database.setProductsMap(new HashMap<String, Product>());
        Database.setOrderMap(new HashMap<String, Order>());


        farmer1.setName("farmer1");
        farmer2.setName("farmer2");
        farmerAccount1.setPersonal_info(farmer1);
        farmerAccount2.setPersonal_info(farmer2);
        farmerAccount1.setDelivers_to(new ArrayList<String>(Arrays.asList("60000","61111")));
        farmerAccount2.setDelivers_to(new ArrayList<String>(Arrays.asList("61111","62222","63333")));

        fam.addFarmerAccount(farmerAccount1);
        fam.addFarmerAccount(farmerAccount2);
    }

    @Test
    public void getAllFarmerAccounts() throws Exception {

        assertEquals(2,fam.getAllFarmerAccounts().size());

    }

    @Test
    public void addFarmerAccount() throws Exception {
        assertEquals("1", farmerAccount1.getFid());
        assertEquals("2", farmerAccount2.getFid());
    }


    @Test
    public void getFarmerAccountById() throws Exception {
        assertEquals("farmer1", fam.getFarmerAccountById("1").getName());
        assertEquals("farmer2", fam.getFarmerAccountById("2").getName());


    }
    @Test(expected = DataNotFoundException.class)
    public void updateFarmerAccountNotExist() throws Exception {
        FarmerAccount farmerAccount3 = new FarmerAccount();
        farmerAccount3.setFid("3");
        fam.updateFarmerAccount(farmerAccount3);

    }

    @Test
    public void updateFarmerAccount() throws Exception {
        Farmer farmer3 = new Farmer();
        farmer3.setName("farmer3");
        farmerAccount2.setPersonal_info(farmer3);
        fam.updateFarmerAccount(farmerAccount2);
        assertEquals("farmer3",fam.getFarmerAccountById("2").getName());

    }

    @Test
    public void findFarmerAccountByZip() throws Exception {
        List<FarmerAccount> farmerAccounts1 = fam.findFarmerAccountByZip("60000");
        List<FarmerAccount> farmerAccounts2 = fam.findFarmerAccountByZip("61111");
        assertEquals(1,farmerAccounts1.size());
        assertEquals(2,farmerAccounts2.size());
        assertEquals("farmer1", farmerAccounts1.get(0).getName());
    }

}