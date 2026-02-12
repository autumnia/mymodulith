package com.autumnia.mymodulith.order.service;

import com.autumnia.mymodulith.order.dto.OrderPaymentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderEventService {
    private final ApplicationEventPublisher eventPublisher;

    public void order_completed(final OrderPaymentDto orderPaymentDto) {
        log.info("completing order payment with details: {}", orderPaymentDto);
        eventPublisher.publishEvent(orderPaymentDto);
    }
}
