package edu.iit.cs445.database;

import edu.iit.cs445.entitites.Catalog;
import edu.iit.cs445.entitites.Customer;
import edu.iit.cs445.entitites.FarmerAccount;
import edu.iit.cs445.entitites.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YongYang on 11/6/16.
 */
public class Database {
    private static Map<Long, Customer> customers = new HashMap<Long, Customer>();
    private static Map<Long, Catalog> catalogs = new HashMap<Long, Catalog>();
    private static Map<Long, FarmerAccount> farmerAccounts= new HashMap<Long, FarmerAccount>();
    private static Map<Long, Map<Long,Product>> farmerAccountsProudctsMap = new HashMap<Long, Map<Long, Product>>();

    public static Map<Long, Customer> getCustomers() {
        return customers;
    }

    public static Map<Long, Catalog> getCatalogs() {
        return catalogs;
    }

    public static Map<Long, FarmerAccount> getFarmerAccounts() {
        return farmerAccounts;
    }

    public static Map<Long, Map<Long, Product>> getFarmerAccountsProudctsMap() {
        return farmerAccountsProudctsMap;
    }
}
