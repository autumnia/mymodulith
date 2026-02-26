package com.autumnia.mymodulith.order.service;

import jakarta.persistence.AttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

public interface OrderService {

    @AllArgsConstructor
    @Getter
    enum OrderStatus {
        OPEN("O"),
        FAILED("F"),
        COMPLIETE("C");

        private final String code;
    }

//    @Converter(autoApply = true)
    final class Smart implements AttributeConverter<OrderStatus, String> {
        @Override
        public String convertToDatabaseColumn(OrderStatus status) {
            return Arrays.stream(OrderStatus.values())
                    .filter(sv -> sv == status )
                    .map(OrderStatus::getCode)
                    .findFirst()
                    .orElseThrow( () -> new IllegalArgumentException("No status found"));
        }

        @Override
        public OrderStatus convertToEntityAttribute(String code) {
            return Arrays.stream(OrderStatus.values())
                    .filter(sc -> sc.getCode().equalsIgnoreCase(code))
                    .findFirst()
                    .orElseThrow( () -> new IllegalArgumentException("No code found"));
        }
    }
}
