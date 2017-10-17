package com.catalogue.product.controllers;


import com.catalogue.product.model.Product;
import com.catalogue.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.beans.Transient;
import java.io.File;
import java.util.List;

@Controller
public class CatalogueController {

    @Autowired
    ProductService productService;





    @RequestMapping("/")
    public String list(Model model) {
        model.addAttribute("title", "Products catalog");
        return "index";
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


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct,
                                           BindingResult result, HttpServletRequest request){

        String[] supressedFields = result.getSuppressedFields();
        if(supressedFields.length > 0){
            throw new RuntimeException("Attempting to bind disallowed fields:"+ StringUtils.arrayToCommaDelimitedString(supressedFields));
        }

        MultipartFile productImage = newProduct.getProductImage();
        String fileName = productImage.getOriginalFilename();

        String rootDirectory = request.getSession().getServletContext().getRealPath("/");

        if(productImage != null && !productImage.isEmpty()){
            try{
                File file = new File(rootDirectory+"\\images\\"+newProduct.getId()+"."+
                        productService.getFileExtension(fileName));
                productImage.transferTo(file);
            } catch( Exception e){
                throw new RuntimeException("Product Image saving failed!", e);
            }
        }
        newProduct.setImageSource(newProduct.getId()+"."+ productService.getFileExtension(fileName));
        productService.saveProduct(newProduct);
        return "redirect:/products";
    }


    @RequestMapping("/add")
    String addProduct(ModelMap modelMap){
        return "index";
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
