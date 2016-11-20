package edu.iit.cs445.usecases;

import edu.iit.cs445.database.Database;
import edu.iit.cs445.database.Helper;
import edu.iit.cs445.entitites.*;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by YongYang on 11/19/16.
 */
public class SearchTest {
    private FarmerAccountManager fam = new FarmerAccountManager();
    private FarmerProductManager fpm = new FarmerProductManager();
    private CatalogManager cm = new CatalogManager();
    private CustomerManager cstm= new CustomerManager();
    private OrderManager om = new OrderManager();

    private Catalog catalog1= new Catalog();
    private Catalog catalog2= new Catalog();
    private Catalog catalog3= new Catalog();

    private Farm farm1=new Farm();
    private Farmer farmer1= new Farmer();

    private FarmerAccount farmerAccount1 = new FarmerAccount();


    private Customer customer1= new Customer();
    private Order order1 = new Order();
    private Order order2 = new Order();

    private Product product1 = new Product();
    private Product product2 = new Product();

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

        farm1.setName("farm1");
        farmer1.setName("farmer1");
        farmerAccount1.setPersonal_info(farmer1);
        farmerAccount1.setFarm_info(farm1);
        farmerAccount1.setDelivers_to(new ArrayList<String>(Arrays.asList("60000","61111")));
        fam.addFarmerAccount(farmerAccount1);

        product1.setGcpid("1");
        product2.setGcpid("2");
        fpm.addFarmerProdcut("1",product1);
        fpm.addFarmerProdcut("1",product2);


        customer1.setName("customer1");
        customer1.setZip("60000");
        cstm.addCustomer(customer1);



        OrderDetail orderDetail1 = new OrderDetail();
        OrderDetail orderDetail2 = new OrderDetail();
        OrderDetail orderDetail3 = new OrderDetail();
        orderDetail1.setFspid("1");
        orderDetail1.setAmount("1.5");
        orderDetail2.setFspid("2");
        orderDetail2.setAmount("8");
        orderDetail3.setFspid("1");
        orderDetail3.setAmount("1");

        order1.setFid("1");
        order2.setFid("1");
        order1.setOrder_detail(new ArrayList<OrderDetail>(Arrays.asList(orderDetail1,orderDetail2)));
        order2.setOrder_detail(new ArrayList<OrderDetail>(Arrays.asList(orderDetail3)));

        om.addCustomerOrder("1",order1);
        om.addCustomerOrder("1",order2);
        customer1.setEmail("searching@email");

    }
    @Test
    public void getCustomersByKey() throws Exception {

        List<Customer> customerList2 = Search.getCustomersByKey("something");
        assertEquals(0,customerList2.size());



    }

    @Test
    public void getFarmerAccountsByKey() throws Exception {

        List<FarmerAccount> farmerAccountList2 = Search.getFarmerAccountsByKey("something");
        assertEquals(0,farmerAccountList2.size());


    }

    @Test
    public void getOrdersByKey() throws Exception {
        List<Order> orderList1 = Search.getOrdersByKey("");
        assertEquals(2,orderList1.size());
        List<Order> orderList2 = Search.getOrdersByKey("1.5");
        assertEquals(1,orderList2.size());

    }

}