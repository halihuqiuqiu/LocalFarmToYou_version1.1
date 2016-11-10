package edu.iit.cs445.usecases;

import edu.iit.cs445.database.Database;
import edu.iit.cs445.entitites.Catalog;
import edu.iit.cs445.exception.DataNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by YongYang on 11/7/16.
 */
public class Manager {
    private Map<Long, Catalog> catalogs= Database.getCatalogs();

    ////
    public List<Catalog> getAllCatalogs() {

        return new ArrayList<Catalog>(catalogs.values());
    }

    public Catalog addCatalog(Catalog catalog) {
        catalog.setGcpid(catalogs.size()+1);
        catalogs.put(catalog.getGcpid(),catalog);
        return catalog;
    }

    public Catalog getCatalogById(long gcpid) {
        Catalog catalog = catalogs.get(gcpid);
        if(catalog==null){
            throw new DataNotFoundException();
        }
        return catalog;
    }

    public Catalog updateCatalog(Catalog catalog) {

        catalogs.put(catalog.getGcpid(), catalog);
        return catalog;
    }
}
