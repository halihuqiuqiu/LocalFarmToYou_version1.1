package edu.iit.cs445.entitites;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YongYang on 11/19/16.
 */
public class ProductTest {
    private Product product = new Product();
    @Test
    public void getPrice() throws Exception {
        product.setPrice(5.00);
        assertEquals("5.0", String.valueOf(product.getPrice()));
        product.setPrice(1.234);
        assertEquals("1.23", String.valueOf(product.getPrice()));
    }

}