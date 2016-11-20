package edu.iit.cs445.entitites;

import edu.iit.cs445.exception.BadRequestException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YongYang on 11/19/16.
 */
public class CustomerTest {
    private Customer customer = new Customer();
    @Test(expected = BadRequestException.class)
    public void validateEntity() throws Exception {
        customer.validateEntity();
    }

}