package com.hoaqt.assignment.repositories;

import com.hoaqt.assignment.models.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderItem, Integer> {
}
