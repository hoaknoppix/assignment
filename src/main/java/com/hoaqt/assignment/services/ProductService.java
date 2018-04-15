package com.hoaqt.assignment.services;

import com.hoaqt.assignment.models.Product;

import java.util.List;

public interface ProductService {
    /**
     * @param filter for querying the products contains this filter string.
     * @param visibleProductsOnly return only the products which are visible if this param is true
     * @return the list of products
     */
    List<Product> getProducts(String filter, boolean visibleProductsOnly);

    /**
     * @param newProduct the new product which is going to added or updated to the system
     * @return the new product if the adding process has been done successfully.
     */
    Product addOrUpdatedProduct(Product newProduct);

    /**
     * @param product the product that is going be removed.
     */
    void removeProduct(Product product);

    /**
     * @param id the product id
     * @return the product with this id
     */
    Product findProductById(Integer id);
}
