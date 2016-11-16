package edu.iit.cs445.usecases;

import edu.iit.cs445.database.Database;
import edu.iit.cs445.entitites.Catalog;
import edu.iit.cs445.entitites.FarmerAccount;
import edu.iit.cs445.entitites.Product;
import edu.iit.cs445.exception.DataNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YongYang on 11/15/16.
 */
public class FarmerProductManager {
    private Map<String, FarmerAccount> farmerAccounts= Database.getFarmerAccounts();
    private Map<String, Map<String,Product>> farmerAccountsProudctsMap = Database.getFarmerAccountsProudctsMap();
    private Map<String, Catalog> catalogs = Database.getCatalogs();
    public List<Product> getAllFarmerProducts(String fid) {

        return new ArrayList<Product>(farmerAccountsProudctsMap.get(fid).values());
    }

    public Product addFarmerProdcut(String fid, Product product ) {
        if(farmerAccounts.get(fid)==null){
            throw new DataNotFoundException();
        }
        product.setFspid(String.valueOf(farmerAccountsProudctsMap.get(fid).size()+1));

        // String name = catalogs.get(product.getGcpid()).getName();
        String name ="name catalogs125";

        product.setName(name);
        Product productbyCatalogName = product;
        productbyCatalogName.setGcpid(null);

        farmerAccountsProudctsMap.get(fid).put(product.getFspid(),productbyCatalogName);
        return product;
    }


    public Product getFarmerProductById(String fid, String fspid) {
        if (farmerAccounts.get(fid)==null||farmerAccountsProudctsMap.get(fid).get(fspid)==null){
            throw new DataNotFoundException();
        }
        Product product = farmerAccountsProudctsMap.get(fid).get(fspid);
        return product;
    }

    public Product partialUpdateFarmerProduct(String fid, Product product) {
        String fspid = product.getFspid();

        if(farmerAccounts.get(fid)==null||getFarmerProductById(fid,fspid)==null){
            throw new DataNotFoundException();
        }

        Product original = farmerAccountsProudctsMap.get(fid).get(fspid);
        if(product.getNote()!=null){
            original.setNote(product.getNote());
        }
        if(product.getStart_date()!=null){
            original.setStart_date(product.getStart_date());
        }
        if (product.getEnd_date()!=null){
            original.setEnd_date(product.getEnd_date());
        }
        if (product.getPrice()!=0){
            original.setPrice(product.getPrice());
        }
        if (product.getProduct_unit()!=null){
            original.setProduct_unit(product.getProduct_unit());
        }
        if (product.getImage()!=null){
            original.setImage(product.getImage());
        }
        farmerAccountsProudctsMap.get(fid).put(product.getFspid(),original);
        return product;
    }
}
