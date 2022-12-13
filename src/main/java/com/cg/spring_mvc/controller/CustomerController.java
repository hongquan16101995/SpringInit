package com.cg.spring_mvc.controller;

import com.cg.spring_mvc.service.ICustomerService;
import com.cg.spring_mvc.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    //annotation @Autowired: dùng để đánh dấu 1 bean được tiêm vào 1 phần của dự án
//    @Autowired
//    private ICustomerService iCustomerService;


    @Autowired
    private ICustomerService customerService;

    @GetMapping(value = "/list")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("customers", customerService.findAll());
        return modelAndView;
    }
}
