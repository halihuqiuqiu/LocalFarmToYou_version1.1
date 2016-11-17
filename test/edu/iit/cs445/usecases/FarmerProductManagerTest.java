package edu.iit.cs445.usecases;

import edu.iit.cs445.database.Database;
import edu.iit.cs445.entitites.FarmerAccount;
import edu.iit.cs445.entitites.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YongYang on 11/16/16.
 */
public class FarmerProductManagerTest {
    FarmerAccount farmerAccount = new FarmerAccount();
    Product product = new Product();
    Product original = new Product("123",null,"Potatoes","These Russets are ideal ","10-01","",0.29,"lb","");
    FarmerProductManager fpm = new FarmerProductManager();

    @Before
    public void setup(){
        farmerAccount.setFid("321");
    }

    /*
    @Test
    public void partialUpdateFarmerProduct() throws Exception {

        product.setPrice(0.37);
        product.setFspid("123");
        fpm.partialUpdateFarmerProduct("321", product);
        assertEquals(0.37, 0.37);
    }
    */

}