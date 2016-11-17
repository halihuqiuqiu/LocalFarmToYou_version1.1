package edu.iit.cs445.usecases;

import edu.iit.cs445.database.Database;
import edu.iit.cs445.entitites.Catalog;
import edu.iit.cs445.entitites.FarmerAccount;
import edu.iit.cs445.entitites.Product;
import edu.iit.cs445.exception.DataNotFoundException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YongYang on 11/15/16.
 */
public class FarmerProductManager {
    private Map<String, FarmerAccount> farmerAccounts= Database.getFarmerAccounts();
    private Map<String, Catalog> catalogs = Database.getCatalogs();
    public List<Product> getAllFarmerProducts(String fid) {
        if(farmerAccounts.get(fid)==null){
            throw new DataNotFoundException();
        }
        return new ArrayList<Product>(farmerAccounts.get(fid).getProductsMap().values());
    }

    public Product addFarmerProdcut(String fid, Product product ) {
        if(farmerAccounts.get(fid)==null){
            throw new DataNotFoundException();
        }
        product.setFspid(String.valueOf(farmerAccounts.get(fid).getProductsMap().size()+1));

        String name = catalogs.get(product.getGcpid()).getName();

        product.setName(name);
        Product productbyCatalogName = product;
        productbyCatalogName.setGcpid(null);

        farmerAccounts.get(fid).getProductsMap().put(product.getFspid(),productbyCatalogName);
        return product;
    }


    public Product getFarmerProductById(String fid, String fspid) {
        if (farmerAccounts.get(fid)==null||farmerAccounts.get(fid).getProductsMap().get(fspid)==null){
            throw new DataNotFoundException();
        }
        Product product = farmerAccounts.get(fid).getProductsMap().get(fspid);
        return product;
    }

    public Product partialUpdateFarmerProduct(String fid, Product product) {
        String fspid = product.getFspid();

        if(farmerAccounts.get(fid)==null||getFarmerProductById(fid,fspid)==null){
            throw new DataNotFoundException();
        }

        Product original = farmerAccounts.get(fid).getProductsMap().get(fspid);

        Field[] fields = product.getClass().getDeclaredFields();

        for( Field field : fields ){ //only change filed required
            field.setAccessible(true);
            try {
                Class type = field.getType();
                Object value = field.get(product);
                if(value != null){
                    field.set(original, value);
                }
                else if(type.equals(double.class) && field.getDouble(product)!= 0){
                    field.setDouble(original, field.getDouble(product));
                }
            } catch (IllegalArgumentException e1) {
            } catch (IllegalAccessException e1) {
            }
        }


        farmerAccounts.get(fid).getProductsMap().put(product.getFspid(),original);
        return product;
    }
}
