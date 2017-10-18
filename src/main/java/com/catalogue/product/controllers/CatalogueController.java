package com.catalogue.product.controllers;


import com.catalogue.product.model.Product;
import com.catalogue.product.service.ProductService;
import com.catalogue.product.utils.ProgramDirectoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URLDecoder;

import java.util.List;

@Controller
public class CatalogueController {

    @Autowired
    ProductService productService;

    @Autowired
    ResourceLoader resourceLoader;


    @RequestMapping("/")
    public String list(Model model) {
        return "products";
    }


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String products(ModelMap modelMap) {
        List<Product> productList = productService.findAllProducts();
        modelMap.addAttribute("productList", productList);
        return "products";
    }

    @RequestMapping(value = "/findAllProducts", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findAllProducts() {
        List<Product> productList = productService.findAllProducts();
        if (productList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }


    @RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
    public String deleteProductById(@RequestParam("id") Long productId){
        productService.deleteProductById(productId);
        return "products";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("product")Product newProduct,
                                           BindingResult result, HttpServletRequest request) {

        String[] supressedFields = result.getSuppressedFields();
        if (supressedFields.length > 0) {
            throw new RuntimeException("Attempting to bind disallowed fields:" + StringUtils.arrayToCommaDelimitedString(supressedFields));
        }

        MultipartFile file = newProduct.getProductImage();
        String fileName = file.getOriginalFilename();


        if(file != null && !file.isEmpty()){
            try{
                File tempFile = new File(ProgramDirectoryUtils.getProgramDirectory() + "\\src\\main\\resources\\images\\" + fileName);
                file.transferTo(tempFile);
            } catch( Exception e){
                throw new RuntimeException("Product Image saving failed!", e);
            }
        }

        newProduct.setImageSource("/images/" + fileName);
        productService.saveProduct(newProduct);
        return "redirect:/products";

    }

    @RequestMapping("/addProduct")
    String addProduct(ModelMap modelMap){
        return "addProduct";
    }


    @RequestMapping(value = "/findProduct/{productId}", method= RequestMethod.GET)
    @ResponseBody
    String findProductById(@PathVariable Long productId,ModelMap modelMap){
        Product product = productService.findById(productId);
        modelMap.addAttribute("product",product);
        return "product";
    }

    @RequestMapping("/save")
    public void saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
    }


}
