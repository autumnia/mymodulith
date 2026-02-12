package com.autumnia.mymodulith.order.dto;

import java.util.List;

public record OrderRequestDto(
        String customerName,
        String customerEmail,
        List<InventoryRequestDto> inventoryRequestDtoList
) {
}

