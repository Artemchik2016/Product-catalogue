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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class CatalogueController {

    @Autowired
    ProductService productService;

    @Autowired
    ResourceLoader resourceLoader;


    @RequestMapping("/")
    public String list() {
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


    @RequestMapping(value = "/updateProduct", method = RequestMethod.GET)
    public String updateProduct(@RequestParam("productId") Long productId, ModelMap modelMap){
        Product product = productService.findById(productId);
        if(product!=null){
            modelMap.addAttribute("product", product);
            return "updateProduct";
        }else{
            return "products";
        }
    }


    @RequestMapping(value = "/updateProductProcess", method = RequestMethod.POST)
    public String updateProcessProduct(@ModelAttribute("product")Product newProduct){
        Product retrievedProduct = productService.findById(newProduct.getId());
        retrievedProduct.setName(newProduct.getName());
        retrievedProduct.setPrice(newProduct.getPrice());
        retrievedProduct.setDescription(newProduct.getDescription());
        productService.updateProduct(retrievedProduct);
        return "products";
    }



    @RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
    public String deleteProductById(@RequestParam("productId") Long productId){
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


        String path = "D:/tempProduct/";
        MultipartFile file = newProduct.getProductImage();
        String fileName = file.getOriginalFilename();
        saveUploadedFile(path,file);


        newProduct.setImageSource("/tempProduct/" + fileName);
        productService.saveProduct(newProduct);
        return "redirect:/products";

    }


    @RequestMapping("/addProduct")
    String addProduct(){
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


    /**
     * Save uploaded file to server
     * @param path Location of the server to save file
     * @param uploadedFile Current uploaded file
     */


    public static void saveUploadedFile(String path, MultipartFile uploadedFile) {
        try {
            //First, Generate file to make directories
            String savedFileName = path + "/" + uploadedFile.getOriginalFilename();
            File fileToSave = new File(savedFileName);
            fileToSave.getParentFile().mkdirs();
            fileToSave.delete();
            //Generate path file to copy file
            Path folder = Paths.get(savedFileName);
            Path fileToSavePath = Files.createFile(folder);
            //Copy file to server
            InputStream input = uploadedFile.getInputStream();
            Files.copy(input, fileToSavePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
