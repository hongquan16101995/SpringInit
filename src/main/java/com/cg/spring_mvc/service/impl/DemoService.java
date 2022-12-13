package com.cg.spring_mvc.service.impl;

import com.cg.spring_mvc.model.Customer;
import com.cg.spring_mvc.service.ICustomerService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component(value = "demoService")
public class DemoService implements ICustomerService {

    private static final List<Customer> customers;

    static {
        customers = new ArrayList<>();
        customers.add(new Customer(1L, "Tú", "tu@gmail.com", "LC"));
    }
    @Override
    public List<Customer> findAll() {
        return customers;
    }
}
