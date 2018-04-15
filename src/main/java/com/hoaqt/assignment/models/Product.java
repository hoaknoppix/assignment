package com.hoaqt.assignment.models;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private BigDecimal price;
    @PositiveOrZero
    private int quantity;
    private boolean visible;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Product) {
            return ((Product) object).getId().equals(this.id);
        }
        return false;
    }
}
