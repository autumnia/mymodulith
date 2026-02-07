package com.autumnia.mymodulith.order.service;

import com.autumnia.mymodulith.inventory.exposed.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
//    private final InventoryRepository inventoryRepository;
    private final InventoryService inventoryService;

//    public void breakTest() {
//        Optional<Inventory> savedInventory = inventoryRepository.getInventoryByName("data");
//        log.info( "inventory present: {}", savedInventory.isPresent() );
//    }


    void test() {
        String status = new Smart().convertToDatabaseColumn(OrderStatus.OPEN);
        log.info("order status: {}", status);
    }
}
