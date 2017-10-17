package com.catalogue.product.utils;

import com.catalogue.product.model.Product;
import com.catalogue.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
class DatabaseLoader implements CommandLineRunner {

    private ProductService productService;

    @Autowired
    public DatabaseLoader(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... strings) throws Exception {
        productService.saveProduct(new Product("Boots", "Winter boots", BigDecimal.valueOf(199),"/images/boots.jpg"));
        productService.saveProduct(new Product("Shoes", "Spring shoes", BigDecimal.valueOf(149),"/images/shoes.jpg"));
        productService.saveProduct(new Product("Moccasin", "Very nice summer moccasin ", BigDecimal.valueOf(219),"/images/moccasin.jpg"));
        productService.saveProduct(new Product("Gladiators", "Autumn gladiators", BigDecimal.valueOf(99.99),"/images/gladiators.jpg"));
    }
}