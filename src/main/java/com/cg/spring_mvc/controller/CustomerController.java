package com.cg.spring_mvc.controller;

import com.cg.spring_mvc.model.City;
import com.cg.spring_mvc.model.Customer;
import com.cg.spring_mvc.service.ICustomerService;
import com.cg.spring_mvc.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    //annotation @Autowired: dùng để đánh dấu 1 bean được tiêm vào 1 phần của dự án
//    @Autowired
//    private ICustomerService iCustomerService;


    @Autowired
    private ICustomerService customerService;

    @ModelAttribute("cities")
    public List<City> getCities() {
        return new CustomerService().getListCity();
    }

    @GetMapping(value = "/list")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("customers", customerService.findAll());
        return modelAndView;
    }

    @GetMapping(value = "/{id}")
    public ModelAndView detailCustomer(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("customer", customerService.findOne(id));
        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        customerService.delete(id);
        return "redirect:/customers/list";
    }

    @GetMapping(value = "/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping(value = "/create")
    public String createCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customers/list";
    }

    @GetMapping(value = "/update/{id}")
    public ModelAndView updateForm(@PathVariable("id") Long id) {
        Customer customer = customerService.findOne(id);
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping(value = "/update")
    public String updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customers/list";
    }
}
