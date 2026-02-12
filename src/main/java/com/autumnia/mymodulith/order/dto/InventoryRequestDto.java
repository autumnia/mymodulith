package com.autumnia.mymodulith.order.dto;

public record InventoryRequestDto(
        String inventoryName,
        int qty
) {
}
