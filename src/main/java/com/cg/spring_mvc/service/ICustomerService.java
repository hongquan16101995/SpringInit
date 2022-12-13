package com.cg.spring_mvc.service;

import com.cg.spring_mvc.model.Customer;;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
}
