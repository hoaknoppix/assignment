package com.hoaqt.assignment.controllers;

import com.hoaqt.assignment.models.Product;
import com.hoaqt.assignment.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/product")
    public String getAdminPage(@RequestParam (defaultValue = "") String filter, Model model) {
        List<Product> products = productService.getProducts(filter, false);
        model.addAttribute("products", products);
        return "admin";
    }

}
