package com.autumnia.mymodulith.order.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    OPEN("O"),
    FAILED("F"),
    COMPLIETE("C");

    private final String code;
}