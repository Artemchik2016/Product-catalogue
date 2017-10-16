package com.catalogue.product.controllers;


import com.catalogue.product.model.Product;
import com.catalogue.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CatalogueController {

    @Autowired
    ProductService productService;

    @RequestMapping("/")
    String home(ModelMap modelMap) {
        modelMap.addAttribute("title","Products catalogue");
        return "index";
    }


    @RequestMapping(value = "/findAllProducts", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findAllProducts() {
        List<Product> productList = productService.findAllProducts();
        if (productList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }



    @RequestMapping("/add")
    String addProduct(ModelMap modelMap){
        return "index";
    }

    @RequestMapping(value = "/findProduct/{productId}", method= RequestMethod.GET)
    @ResponseBody
    Product findProductById(@PathVariable Long productId){
        return productService.findById(productId);
    }

    @RequestMapping("/save")
    public void saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
    }





}
