package com.hoaqt.assignment.services;

import com.hoaqt.assignment.exceptions.OutOfStockException;
import com.hoaqt.assignment.models.OrderItem;
import com.hoaqt.assignment.models.Product;
import com.hoaqt.assignment.repositories.OrderRepository;
import com.hoaqt.assignment.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<OrderItem> getOrders() {
        return (List<OrderItem>) orderRepository.findAll();
    }

    @Override
    @Transactional
    public OrderItem addOrder(OrderItem newOrder) {
        Product product = newOrder.getProduct();
        product = updateProductQuantity(product, newOrder.getQuantity());
        newOrder.setProduct(productRepository.save(product));
        return orderRepository.save(newOrder);
    }

    private Product updateProductQuantity(Product product, int newQuantity) {
        int newProductQuantity = product.getQuantity() - newQuantity;
        if (newProductQuantity < 0) {
            throw new OutOfStockException();
        }
        product.setQuantity(newProductQuantity);
        product = productRepository.save(product);
        return product;
    }

    @Override
    @Transactional
    public OrderItem updateOrder(OrderItem order, Product product, int newQuantity) {
        if (order.getProduct().equals(product)) {
            product = updateProductQuantity(product, newQuantity - order.getQuantity());
            order.setProduct(product);
        }
        order.setQuantity(newQuantity);
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public void removeOrder(OrderItem order) {
        updateProductQuantity(order.getProduct(), -order.getQuantity());
        orderRepository.delete(order);
    }

    @Override
    public OrderItem findOrderById(Integer id) {
        Optional<OrderItem> optionalOrder = orderRepository.findById(id);
        return optionalOrder.get();
    }
}
