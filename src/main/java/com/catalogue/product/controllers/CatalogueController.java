package com.catalogue.product.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CatalogueController {

    @RequestMapping("/")
    String home(ModelMap modal) {
        modal.addAttribute("title","Products catalogue");
        return "index";
    }


    @RequestMapping("/add")
    String addProduct(){
        return "index";
    }

}
