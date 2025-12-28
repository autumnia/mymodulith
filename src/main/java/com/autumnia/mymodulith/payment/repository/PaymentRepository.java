package com.autumnia.mymodulith.payment.repository;

import com.autumnia.mymodulith.payment.entity.Payment;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PaymentRepository extends CrudRepository<Payment, Long>  {
    Optional<Payment> getPaymentsByOrderId(String orderId);
}

