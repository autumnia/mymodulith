package com.autumnia.mymodulith.order.repository;

import com.autumnia.mymodulith.order.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    Optional<Order> getOrderByOrderIdentifier(String orderIdentifier);

}
