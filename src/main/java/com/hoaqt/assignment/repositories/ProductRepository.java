package com.hoaqt.assignment.repositories;

import com.hoaqt.assignment.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findByNameContaining(String name);
    List<Product> findByNameContainingAndVisible(String name, boolean visible);
}
