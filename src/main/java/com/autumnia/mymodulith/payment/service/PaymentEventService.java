package com.autumnia.mymodulith.payment.service;

import com.autumnia.mymodulith.order.dto.OrderPaymentDto;
import com.autumnia.mymodulith.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentEventService {
    private final PaymentRepository paymentRepository;
//    private final OrderService orderService;

    @Async
    @TransactionalEventListener
    void on(final OrderPaymentDto orderPaymentDto) {
        log.info( "order payment received in listener: {}", orderPaymentDto);

    }
}
