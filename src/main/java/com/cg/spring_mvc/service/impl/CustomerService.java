package com.cg.spring_mvc.service.impl;

import com.cg.spring_mvc.model.City;
import com.cg.spring_mvc.model.Customer;
import com.cg.spring_mvc.service.ICustomerService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "customerService")
public class CustomerService implements ICustomerService {
    private static final List<Customer> customers;
    private static final List<City> cities;

    static {
        cities = new ArrayList<>();
        cities.add(new City(1L, "HN"));
        cities.add(new City(2L, "HCM"));
        customers = new ArrayList<>();
        customers.add(new Customer(11L, "Tú", "tu@gmail.com", "LC", cities.get(0)));
        customers.add(new Customer(25L, "Thành", "thanh@gmail.com", "HN", cities.get(0)));
        customers.add(new Customer(36L, "Huy", "huy@gmail.com", "HN", cities.get(1)));
    }

    public List<City> getListCity() {
        return cities;
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
