package com.hoaqt.assignment.controllers;

import com.hoaqt.assignment.services.OrderService;
import com.hoaqt.assignment.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @RequestMapping("/shop-n-cart")
    public String getShoppingCartPage(Model model) {
        model.addAttribute("products", productService.getProducts("", true));
        model.addAttribute("orders", orderService.getOrders());
        return "shoppingcart";
    }
}
