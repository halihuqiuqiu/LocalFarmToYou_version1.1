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
    private static Map<String, Customer> customers = new HashMap<String, Customer>();
    private static Map<String, Catalog> catalogs = new HashMap<String, Catalog>();
    private static Map<String, FarmerAccount> farmerAccounts= new HashMap<String, FarmerAccount>();
    private static Map<String, Map<String,Product>> farmerAccountsProudctsMap = new HashMap<String, Map<String, Product>>();

    public static Map<String, Customer> getCustomers() {
        return customers;
    }

    public static Map<String, Catalog> getCatalogs() {
        return catalogs;
    }

    public static Map<String, FarmerAccount> getFarmerAccounts() {
        return farmerAccounts;
    }

    public static Map<String, Map<String, Product>> getFarmerAccountsProudctsMap() {
        return farmerAccountsProudctsMap;
    }
}
