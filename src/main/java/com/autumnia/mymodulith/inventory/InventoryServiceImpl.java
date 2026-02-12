package com.autumnia.mymodulith.inventory;

import com.autumnia.mymodulith.inventory.exposed.InventoryDto;
import com.autumnia.mymodulith.inventory.exposed.InventoryService;
import com.autumnia.mymodulith.order.dto.InventoryRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;

    @Override
    public InventoryDto fetchInventoryByName(String name) {
        return inventoryRepository.getInventoryByName(name)
                .map(inv -> new Smart().map_to_dto(inv) )
                .orElseThrow(() -> new IllegalArgumentException("Could not find inventory by name: " + name));
    }

    @Override
    public List<InventoryDto> fetchAllByName(List<String> inventoryNames) {
        return inventoryRepository.getInventoryByNameIn(inventoryNames)
                .stream()
                .map(inv -> new Smart().map_to_dto(inv))
                .toList();
    }
}
