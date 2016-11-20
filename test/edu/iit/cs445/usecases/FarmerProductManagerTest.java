package edu.iit.cs445.usecases;

import edu.iit.cs445.database.Database;
import edu.iit.cs445.database.Helper;
import edu.iit.cs445.entitites.*;
import edu.iit.cs445.exception.DataNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by YongYang on 11/16/16.
 */
public class FarmerProductManagerTest {

    private FarmerAccountManager fam = new FarmerAccountManager();
    private FarmerProductManager fpm = new FarmerProductManager();
    private CatalogManager cm = new CatalogManager();

    private Catalog catalog1= new Catalog();
    private Catalog catalog2= new Catalog();
    private Catalog catalog3= new Catalog();

    private Farmer farmer1= new Farmer();
    private FarmerAccount farmerAccount = new FarmerAccount();

    Product product1 = new Product();
    Product product2 = new Product();


    @Before
    public void setup(){
        Database.setCustomers(new HashMap<String, Customer>());
        Database.setCatalogs(new HashMap<String, Catalog>());
        Database.setFarmerAccounts(new HashMap<String, FarmerAccount>());
        Database.setManagerMap(Helper.getManagerMapWithSystemManager());
        Database.setProductsMap(new HashMap<String, Product>());
        Database.setOrderMap(new HashMap<String, Order>());

        catalog1.setName("Potatoes");
        catalog2.setName("Tomatoes");
        catalog3.setName("Eggplant");
        cm.addCatalog(catalog1);
        cm.addCatalog(catalog2);
        cm.addCatalog(catalog3);

        farmer1.setName("farmer1");
        farmerAccount.setPersonal_info(farmer1);
        fam.addFarmerAccount(farmerAccount);

        product1.setGcpid("1");
        product2.setGcpid("2");
        fpm.addFarmerProdcut("1",product1);
        fpm.addFarmerProdcut("1",product2);
    }

    @Test(expected = DataNotFoundException.class)
    public void getAllFarmerProductsFarmerNotExist() throws Exception {
        fpm.getAllFarmerProducts("2");
    }
    @Test
    public void getAllFarmerProducts() throws Exception {
        assertEquals(2,fpm.getAllFarmerProducts("1").size());

    }

    @Test
    public void addFarmerProdcut() throws Exception {

        assertEquals("1",product1.getFspid());
        assertEquals("2",product2.getFspid());
        assertEquals("Potatoes",product1.getName());
        assertEquals("Tomatoes",product2.getName());
        assertEquals(2,farmerAccount.getProductsMap().size());
        assertEquals(2,Database.getProductsMap().size());
    }
    @Test(expected = DataNotFoundException.class)
    public void getFarmerProductByIdNotExist() throws Exception {
        fpm.getFarmerProductById("2","1");
    }

    @Test
    public void getFarmerProductById() throws Exception {
        assertEquals("Tomatoes",fpm.getFarmerProductById("1","2").getName());
        assertEquals("Potatoes",fpm.getFarmerProductById("1","1").getName());


    }


    @Test(expected = DataNotFoundException.class)
    public void partialUpdateFarmerProductNotExistFarmer() throws Exception {
        Product product3 = new Product();
        product3.setFspid("2");
        product3.setPrice(0.37);
        fpm.partialUpdateFarmerProduct("2",product3);

    }

    @Test(expected = DataNotFoundException.class)
    public void partialUpdateFarmerProductNotExistFarmerProduct() throws Exception {
        Product product3 = new Product();
        product3.setFspid("7");
        product3.setPrice(0.37);
        fpm.partialUpdateFarmerProduct("1",product3);

    }

    @Test
    public void partialUpdateFarmerProduct() throws Exception {
        Product product3 = new Product();
        product3.setFspid("2");
        product3.setPrice(0.37);
        fpm.partialUpdateFarmerProduct("1",product3);
        assertEquals(0.37,fpm.getFarmerProductById("1","2").getPrice(),0.01);


    }

}