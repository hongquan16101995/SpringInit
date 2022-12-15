package com.cg.spring_mvc.config;

import com.cg.spring_mvc.service.ICustomerService;
import com.cg.spring_mvc.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
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
//annotation dùng để config đường dẫn đến file properties tĩnh của dự án
@PropertySource("classpath:upload.properties")
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

    //annotation @Value để gọi đến các giá trị đặt sẵn trong phần tài nguyên tĩnh đã đăng ký
    @Value("${upload}")
    private String fileUpload;

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

    //Cấu hình upload file
    //tạo Bean để đăng ký đường dẫn đến nơi chứa file trong dự án
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**")
                .addResourceLocations("file:" + fileUpload);

    }

    //config quy định kích thước tối đa của 1 file khi gửi lên server (hiện là 5Mb)
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSizePerFile(52428800);
        return resolver;
    }

    //tạo Bean cho Customer Service
    @Bean
    public ICustomerService customerService() {
        return new CustomerService();
    }
}
