package edu.iit.cs445.usecases;

import edu.iit.cs445.database.Database;
import edu.iit.cs445.database.Helper;
import edu.iit.cs445.entitites.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by YongYang on 11/19/16.
 */
public class CatalogManagerTest {

    private CatalogManager cm = new CatalogManager();
    Catalog catalog1= new Catalog();
    Catalog catalog2= new Catalog();
    Catalog catalog3= new Catalog();



    @Before
    public void setup() {
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
    }
    @Test
    public void getAllCatalogs() throws Exception {
        List<Catalog> catalogList = cm.getAllCatalogs();
        assertEquals(3,catalogList.size());
        assertEquals("Eggplant",catalogList.get(2).getName());
    }

    @Test
    public void addCatalog() throws Exception {
        assertEquals("1",catalog1.getGcpid());
        assertEquals("2",catalog2.getGcpid());
        assertEquals("3",catalog3.getGcpid());

    }

    @Test
    public void getCatalogById() throws Exception {
        assertEquals("Eggplant", cm.getCatalogById("3").getName());
        assertEquals("Potatoes", cm.getCatalogById("1").getName());

    }

    @Test
    public void updateCatalog() throws Exception {
        catalog1.setName("Potatoes (red)");
        cm.updateCatalog(catalog1);
        assertEquals("Potatoes (red)",cm.getCatalogById("1").getName());

    }

}