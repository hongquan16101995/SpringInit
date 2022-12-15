package com.cg.spring_mvc.config;

import com.cg.spring_mvc.service.ICustomerService;
import com.cg.spring_mvc.service.impl.CustomerService;
import com.cg.spring_mvc.service.impl.DemoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

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
//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/views/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }

    //cấu hình Thymeleaf
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/view/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }

    @Bean
    public ICustomerService customerService() {
        return new CustomerService();
    }

//    @Bean
//    public ICustomerService demoService() {
//        return new DemoService();
//    }
}
