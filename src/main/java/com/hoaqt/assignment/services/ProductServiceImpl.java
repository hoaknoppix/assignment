package com.hoaqt.assignment.services;

import com.hoaqt.assignment.models.Product;
import com.hoaqt.assignment.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts(String filter, boolean visibleProductsOnly) {
        if (visibleProductsOnly) {
            return productRepository.findByNameContainingAndVisible(filter, visibleProductsOnly);
        }
        return productRepository.findByNameContaining(filter);
    }

    @Override
    public Product addOrUpdatedProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }

    @Override
    public void removeProduct(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Product findProductById(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.get();
    }
}
