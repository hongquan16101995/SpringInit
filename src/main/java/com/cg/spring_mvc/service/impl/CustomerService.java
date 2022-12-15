package com.cg.spring_mvc.service.impl;

import com.cg.spring_mvc.model.Customer;
import com.cg.spring_mvc.service.ICustomerService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//annotation @Component để đánh dấu đây là 1 Bean trong dự án, được quản lý bởi IoCContainer
@Component(value = "customerService")
public class CustomerService implements ICustomerService {
    private static final List<Customer> customers;

    static {
        customers = new ArrayList<>();
        customers.add(new Customer(11L, "Tú", "tu@gmail.com", "LC"));
        customers.add(new Customer(25L, "Thành", "thanh@gmail.com", "HN"));
        customers.add(new Customer(36L, "Huy", "huy@gmail.com", "HN"));
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findOne(Long id) {
        for (Customer c : customers) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        customers.removeIf(c -> c.getId().equals(id));
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() == null) {
            customer.setId( Long.parseLong(String.valueOf((int)(Math.random()* 1000))));
            customers.add(customer);
        } else {
            Customer customerUpdate = findOne(customer.getId());
            customers.set(customers.indexOf(customerUpdate), customer);
        }
    }
}
