package edu.iit.cs445.usecases;

import edu.iit.cs445.database.Database;
import edu.iit.cs445.database.Helper;
import edu.iit.cs445.entitites.*;
import edu.iit.cs445.exception.DataNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by YongYang on 11/19/16.
 */
public class OrderManagerTest {
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
    private FarmerAccount farmerAccount = new FarmerAccount();

    private Customer customer= new Customer();
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
        farmerAccount.setPersonal_info(farmer1);
        farmerAccount.setFarm_info(farm1);
        farmerAccount.setDelivers_to(new ArrayList<String>(Arrays.asList("60000","61111")));
        fam.addFarmerAccount(farmerAccount);

        product1.setGcpid("1");
        product2.setGcpid("2");
        fpm.addFarmerProdcut("1",product1);
        fpm.addFarmerProdcut("1",product2);


        customer.setName("customer1");
        customer.setZip("60000");
        cstm.addCustomer(customer);



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

    }

    @Test(expected = DataNotFoundException.class)
    public void getAllCustomerOrdersNotExist() throws Exception {
        om.getAllCustomerOrders("2");

    }
    @Test
    public void getAllCustomerOrders() throws Exception {
        assertEquals(2,om.getAllCustomerOrders("1").size());
    }

    @Test(expected = DataNotFoundException.class)
    public void addCustomerOrderNotExist() throws Exception {
       om.addCustomerOrder("2",order1);

    }

    @Test
    public void addCustomerOrder() throws Exception {
        assertEquals("1",order1.getOid());
        assertEquals("2",order2.getOid());
        assertEquals("1", order1.getOrder_detail().get(0).getFspid());
        assertEquals(2,customer.getOrderMap().size());
        assertEquals(2,Database.getOrderMap().size());

    }

    @Test(expected = DataNotFoundException.class)
    public void getCustomerOrderByIdNotExist() throws Exception {

        om.getCustomerOrderById("3","1");

    }
    @Test(expected = DataNotFoundException.class)
    public void getCustomerOrderByIdNotExistOrder() throws Exception {

        om.getCustomerOrderById("1","3");

    }
    @Test
    public void getCustomerOrderById() throws Exception {

        assertEquals("2",om.getCustomerOrderById("1","1").getOrder_detail().get(1).getFspid());
        assertEquals("1",om.getCustomerOrderById("1","1").getOrder_detail().get(0).getFspid());

    }

    @Test(expected = DataNotFoundException.class)
    public void cancelOrderNoExist() throws Exception {
        Order order = new Order();
        order.setStatus("cancelled");
        order.setOid("3");

        om.cancelOrder("1",order);
        assertEquals("cancelled",om.getCustomerOrderById("1","2").getStatus());

    }
    @Test
    public void cancelOrder() throws Exception {

        Order order = new Order();
        order.setStatus("cancelled");
        order.setOid("2");

        om.cancelOrder("1",order);
        assertEquals("cancelled",om.getCustomerOrderById("1","2").getStatus());
    }

    @Test(expected = DataNotFoundException.class)
    public void deliveredOrderNotExist() throws Exception {
        Order order = new Order();
        order.setStatus("delivered");
        order.setOid("3");

        om.deliveredOrder(order);
        assertEquals("delivered",om.getCustomerOrderById("1","2").getStatus());

    }
    @Test
    public void deliveredOrder() throws Exception {
        Order order = new Order();
        order.setStatus("delivered");
        order.setOid("2");

        om.deliveredOrder(order);
        assertEquals("delivered",om.getCustomerOrderById("1","2").getStatus());
    }


}