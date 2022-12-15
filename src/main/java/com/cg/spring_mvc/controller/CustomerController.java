package com.cg.spring_mvc.controller;

import com.cg.spring_mvc.model.Customer;
import com.cg.spring_mvc.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    //annotation @Autowired: dùng để đánh dấu 1 bean được tiêm vào 1 phần của dự án
    @Autowired
    private ICustomerService customerService;

    //annotation @ModelAttribute dùng để gửi dữ liệu theo tất cả các request trong controller tương ứng
    //hỗ trợ gửi dữ liệu mà không cần thêm trong model
    @ModelAttribute("customers")
    public List<Customer> getCustomers() {
        return customerService.findAll();
    }

    @GetMapping(value = "/list")
    public ModelAndView findAll() {
        return new ModelAndView("product/list");
    }

    @GetMapping(value = "/{id}")
    public ModelAndView detailCustomer(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("product/detail");
        modelAndView.addObject("customer", customerService.findOne(id));
        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        customerService.delete(id);
        return "redirect:/customers/list";
    }

    @GetMapping(value = "/create")
    public ModelAndView createForm(Model model) {
        ModelAndView modelAndView = new ModelAndView("product/create");
        model.addAttribute("customer", new Customer());
        return modelAndView;
    }

    //phương thức dùng chung cho cả create và update do đã xử lý chức năng trong service
    @PostMapping(value = "/save")
    public String createCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customers/list";
    }

    @GetMapping(value = "/update/{id}")
    public ModelAndView updateForm(@PathVariable("id") Long id) {
        Customer customer = customerService.findOne(id);
        ModelAndView modelAndView = new ModelAndView("product/update");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
}
