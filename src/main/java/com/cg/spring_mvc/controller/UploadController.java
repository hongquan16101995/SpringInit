package com.cg.spring_mvc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class UploadController {
    @Value("${upload}")
    private String fileUpload;

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("upload");
    }

    @PostMapping
    //lớp MultipartFile là lớp đặc biệt, đại diện cho file gửi về từ FE cho server
    public ModelAndView upload(@RequestParam("file") MultipartFile multipartFile) {
        //lấy tên của file
        String fileName = multipartFile.getOriginalFilename();
        try {
            //phương thức để copy file từ file sang thư mục đã quy định trong dự án
            //đường dẫn được quy định trong upload properties
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch ( IOException ex) {
            ex.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView("upload");
        modelAndView.addObject("image",  fileName);
        modelAndView.addObject("message", "OK!");
        return modelAndView;
    }
}
