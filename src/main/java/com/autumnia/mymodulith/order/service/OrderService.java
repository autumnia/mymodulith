package com.autumnia.mymodulith.order.service;

import jakarta.persistence.AttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

public interface OrderService {

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
