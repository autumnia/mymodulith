package com.autumnia.mymodulith.payment.service;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

public interface PaymentService {

    @Converter(autoApply = true)
    final class Smart implements AttributeConverter<PaymentStatus, String> {
        @Override
        public String convertToDatabaseColumn(PaymentStatus status) {
            if ( status == null ) throw new IllegalArgumentException("paymentStatus can not be null");
            return status.getCode();
        }

        @Override
        public PaymentStatus convertToEntityAttribute(String paymentCode) {
            if ( paymentCode == null ) throw new IllegalArgumentException("paymentCode can not be null");
            return Arrays.stream(PaymentStatus.values())
                    .filter( s -> s.getCode().equalsIgnoreCase(paymentCode) )
                    .findFirst()
                    .orElseThrow( () -> new IllegalArgumentException("paymentCode can not be null") );
        }
    }
}
