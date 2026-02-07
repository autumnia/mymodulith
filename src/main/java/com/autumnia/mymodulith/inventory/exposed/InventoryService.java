package com.autumnia.mymodulith.inventory.exposed;

import com.autumnia.mymodulith.inventory.InventoryEntity;
import lombok.experimental.UtilityClass;

import java.util.List;

public interface InventoryService {
    InventoryRequestDto fetchInventoryByName(String name) ;
    List<InventoryRequestDto> fetchAllByName(List<String> inventoryNames );

    final class Smart {
        public InventoryRequestDto map_to_dto(InventoryEntity inventoryEntity) {
            return new InventoryRequestDto(
                    inventoryEntity.getId(),
                    inventoryEntity.getName(),
                    inventoryEntity.getDescription(),
                    inventoryEntity.getPrice()
            );
        }
    }
}
