package com.autumnia.mymodulith.payment.repository;

import com.autumnia.mymodulith.payment.PaymentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends CrudRepository<PaymentEntity, Long>  {
    Optional<PaymentEntity> getPaymentsByOrderId(String orderId);
}

