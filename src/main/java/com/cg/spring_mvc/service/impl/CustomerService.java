package com.cg.spring_mvc.service.impl;

import com.cg.spring_mvc.model.Customer;
import com.cg.spring_mvc.service.ICustomerService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "customerService")
public class CustomerService implements ICustomerService {
    private static final List<Customer> customers;

    static {
        customers = new ArrayList<>();
        customers.add(new Customer(1L, "Tú", "tu@gmail.com", "LC"));
        customers.add(new Customer(2L, "Thành", "thanh@gmail.com", "HN"));
        customers.add(new Customer(3L, "Huy", "huy@gmail.com", "HN"));
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }
}
