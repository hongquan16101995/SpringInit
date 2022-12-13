package com.cg.spring_mvc.controller;

import com.cg.spring_mvc.model.Customer;
import com.cg.spring_mvc.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
//annotation @RequestMapping dùng để định danh đường dẫn ở mức độ class cho các controllers
//FrontController sẽ dựa theo URL và định danh này để chỉ định đến controller tương ứng
//annotation @Controller dùng để đánh dấu đây là 1 controller
@RequestMapping("/products")
public class ProductController {

    @GetMapping(value = "/list")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("demo");
        return modelAndView;
    }

    @GetMapping(value = "/demo/{text}")
    public ModelAndView view(@PathVariable("text") String text) {
        ModelAndView modelAndView = new ModelAndView("demo");
        modelAndView.addObject("text", text);
        modelAndView.addObject("thanh", "Thành");
        modelAndView.addObject("object", new Customer(1L, "Tú", "tu@gmail.com", "LC"));
        return modelAndView;
    }

    @RequestMapping(value = "/demo", method = RequestMethod.POST)
    public ModelAndView view1(@RequestParam("username") String name) {
        ModelAndView modelAndView = new ModelAndView("demo");
        modelAndView.addObject("text", name);
        modelAndView.addObject("thanh", "Thành");
        modelAndView.addObject("object", new Customer(1L, "Tú", "tu@gmail.com", "LC"));
        return modelAndView;
    }
}
