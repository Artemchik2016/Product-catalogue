package com.catalogue.product.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ResourceConfig {

    public class MvcConfig extends WebMvcConfigurerAdapter {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            String myExternalFilePath = "file:///D:/tempProduct/";
            registry.addResourceHandler("/tempProduct/**").addResourceLocations(myExternalFilePath);
            super.addResourceHandlers(registry);
        }
    }

}
