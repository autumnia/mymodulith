package com.autumnia.mymodulith.order.repository;

import com.autumnia.mymodulith.order.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
    Optional<OrderEntity> getOrderByOrderIdentifier(String orderIdentifier);

}
