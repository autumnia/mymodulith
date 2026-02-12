package com.autumnia.mymodulith.payment.service;

import com.autumnia.mymodulith.order.dto.OrderPaymentDto;
import com.autumnia.mymodulith.order.service.OrderService;
import com.autumnia.mymodulith.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentEventService {
    private final PaymentRepository paymentRepository;
//    private final OrderService orderService;

    void on(final OrderPaymentDto orderPaymentDto) {

    }
}
