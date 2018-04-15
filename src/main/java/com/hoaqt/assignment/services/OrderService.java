package com.hoaqt.assignment.services;

import com.hoaqt.assignment.models.OrderItem;
import com.hoaqt.assignment.models.Product;

import javax.persistence.criteria.Order;
import java.util.List;

public interface OrderService {
    /**
     * @return list of orders
     */
    List<OrderItem> getOrders();

    /**
     * @param order the order which is going be added
     * @return the result order after adding
     */
    OrderItem addOrder(OrderItem order);

    /**
     * @param order the order
     * @param product the new product of the order that needs to be updated
     * @param quantity the new quantity of the order that needs to be updated
     * @return the result order after updating
     */
    OrderItem updateOrder(OrderItem order, Product product, int quantity);

    /**
     * @param order the order which is going be deleted
     */
    void removeOrder(OrderItem order);

    /**
     * @param id the id of the order
     * @return the order which has the requested id
     */
    OrderItem findOrderById(Integer id);
}
