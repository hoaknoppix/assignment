package com.hoaqt.assignment.models;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private Product product;
    @Positive
    private int quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }
}
