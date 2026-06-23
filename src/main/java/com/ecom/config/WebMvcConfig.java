package com.ecom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Expose external uploads directory to serve images dynamically in production
        String userDir = System.getProperty("user.dir");
        String uploadPath = "file:" + userDir + File.separator + "uploads" + File.separator;
        
        registry.addResourceHandler("/img/**")
                .addResourceLocations(uploadPath)
                .addResourceLocations("classpath:/static/img/");
    }
}
