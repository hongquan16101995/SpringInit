package com.cg.spring_mvc.config;

import com.cg.spring_mvc.service.ICustomerService;
import com.cg.spring_mvc.service.impl.CustomerService;
import com.cg.spring_mvc.service.impl.DemoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//annotation @Configuration đánh dấu đây là 1 class dùng để config (cài đặt)
@Configuration
//annotation @EnableWebMvc cho phép sử dụng các annotation khác trong dự án MVC
@EnableWebMvc
//annotations @ComponentScan dùng để quét qua các package, nhằm tìm các Bean
//được định danh bằng các annotation khác, đưa về IoCContainer khởi tạo trước
@ComponentScan("com.cg.spring_mvc")
public class AppConfig implements WebMvcConfigurer {

    //annotation @Bean dùng để định danh cho các Bean, được tạo thông qua 1 phương thức
    //annotation @Component dùng để định danh cho các Bean, được tạo thông qua 1 class
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public ICustomerService customerService() {
        return new CustomerService();
    }

    @Bean
    public ICustomerService demoService() {
        return new DemoService();
    }
}
