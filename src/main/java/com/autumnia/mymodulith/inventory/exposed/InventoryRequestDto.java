package com.autumnia.mymodulith.inventory.exposed;

public record InventoryRequestDto(
        Long id,
        String name,
        String description,
        long price
) {
}