package com.hoaqt.assignment.controllers;

import com.hoaqt.assignment.models.Product;
import com.hoaqt.assignment.services.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@Api(value ="Assignment", description = "Operations for product")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<Product> getAllProducts(@RequestParam(required = false, defaultValue = "") String filter, @RequestParam (required = false, defaultValue = "true") boolean visibleProductsOnly) {
        return productService.getProducts(filter, visibleProductsOnly);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public Product addProduct(@RequestBody Product product) {
        return productService.addOrUpdatedProduct(product);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/remove/{id}")
    public ResponseEntity removeProduct(@PathVariable Integer id) {
        Product product = productService.findProductById(id);
        productService.removeProduct(product);
        return new ResponseEntity("Product has been removed", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/update/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        Product updatingProduct = productService.findProductById(id);
        updatingProduct.setName(product.getName());
        updatingProduct.setVisible(product.isVisible());
        updatingProduct.setQuantity(product.getQuantity());
        updatingProduct.setPrice(product.getPrice());
        return productService.addOrUpdatedProduct(updatingProduct);
    }
}
