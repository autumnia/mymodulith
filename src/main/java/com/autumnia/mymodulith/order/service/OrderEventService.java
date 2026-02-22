package com.autumnia.mymodulith.order.service;

import com.autumnia.mymodulith.order.dto.OrderPaymentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderEventService {
    private final ApplicationEventPublisher eventPublisher;


    @Transactional
    public void complete_order(final OrderPaymentDto orderPaymentDto) {
        log.info("completing order payment with details: {}", orderPaymentDto);
        eventPublisher.publishEvent(orderPaymentDto);
    }
}
