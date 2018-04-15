package com.hoaqt.assignment.controllers;

import com.hoaqt.assignment.dtos.OrderRequest;
import com.hoaqt.assignment.models.OrderItem;
import com.hoaqt.assignment.models.Product;
import com.hoaqt.assignment.services.OrderService;
import com.hoaqt.assignment.services.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/order")
@Api(value ="Assignment", description = "Operations for order")
public class OrderRestController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<OrderItem> getAllOrders() {
        return orderService.getOrders();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public OrderItem addOrder(@RequestBody OrderRequest orderRequest) {
        OrderItem order = new OrderItem();
        Product product = productService.findProductById(orderRequest.getProductId());
        order.setProduct(product);
        order.setQuantity(orderRequest.getQuantity());
        return orderService.addOrder(order);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/remove/{id}")
    public ResponseEntity removeOrder(@PathVariable Integer id) {
        OrderItem order = orderService.findOrderById(id);
        orderService.removeOrder(order);
        return new ResponseEntity("Order has been removed", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/update/{id}")
    public OrderItem updateOrder(@PathVariable Integer id, @RequestBody OrderRequest orderRequest) {
        OrderItem order = orderService.findOrderById(id);
        Product product = productService.findProductById(orderRequest.getProductId());
        return orderService.updateOrder(order, product, orderRequest.getQuantity());
    }
}
