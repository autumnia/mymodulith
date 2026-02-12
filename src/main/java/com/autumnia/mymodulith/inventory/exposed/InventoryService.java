package com.autumnia.mymodulith.inventory.exposed;

import com.autumnia.mymodulith.inventory.InventoryEntity;
import com.autumnia.mymodulith.order.dto.InventoryRequestDto;

import java.util.List;

public interface InventoryService {
    InventoryDto fetchInventoryByName(String name) ;
    List<InventoryDto> fetchAllByName(List<String> inventoryNames );

    final class Smart {
        public InventoryDto map_to_dto(InventoryEntity inventoryEntity) {
            return new InventoryDto(
                    inventoryEntity.getId(),
                    inventoryEntity.getName(),
                    inventoryEntity.getDescription(),
                    inventoryEntity.getPrice()
            );
        }
    }
}
