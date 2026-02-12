package com.autumnia.mymodulith.inventory.exposed;

public record InventoryDto(
        Long id,
        String name,
        String description,
        long price
) {
}