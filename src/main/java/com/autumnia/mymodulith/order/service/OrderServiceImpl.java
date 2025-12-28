package com.autumnia.mymodulith.order.service;

import com.autumnia.mymodulith.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;

    void test() {
        String status = new Smart().convertToDatabaseColumn(OrderStatus.OPEN);
        log.info("order status: {}", status);
    }
}
