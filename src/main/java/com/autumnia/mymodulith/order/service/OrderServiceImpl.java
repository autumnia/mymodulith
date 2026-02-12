package com.autumnia.mymodulith.order.service;

import com.autumnia.mymodulith.inventory.exposed.InventoryDto;
import com.autumnia.mymodulith.inventory.exposed.InventoryService;
import com.autumnia.mymodulith.order.dto.InventoryRequestDto;
import com.autumnia.mymodulith.order.dto.OrderRequestDto;
import com.autumnia.mymodulith.order.OrderEntity;
import com.autumnia.mymodulith.order.OrderInventoryEntity;
import com.autumnia.mymodulith.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final InventoryService inventoryService;
    private final OrderRepository orderRepository;

    public OrderRequestDto createOrder(OrderRequestDto orderRequestDto) {
        // get inventories by name
        List<String> inventory_names = orderRequestDto.inventoryRequestDtoList()
                .stream()
                .map(InventoryRequestDto::inventoryName)
                .toList();

        // get inventories
        List<InventoryDto> inventoryDtoList = inventoryService.fetchAllByName(inventory_names);

        // save order
        OrderEntity orderEntity = this.save_order(orderRequestDto);
        log.info("Order created: {}", orderEntity);

        // save inventory
        final AtomicLong amout = new AtomicLong();
        this.save_order_inventory(orderRequestDto, inventoryDtoList, orderEntity.getId(), amout );


        return null;
    }

    private void save_order_inventory(
            OrderRequestDto orderRequestDto,
            List<InventoryDto> inventoryDtoList,
            long order_id,
            AtomicLong amount
    ) {
        List<OrderInventoryEntity> orderInventoryEntities = new ArrayList<>(inventoryDtoList.size());
        inventoryDtoList.forEach( inventoryDto -> {
            OrderInventoryEntity orderInventoryEntity = new OrderInventoryEntity();
            InventoryRequestDto inventoryRequestDto = getIventoryReqeustDtoByName(
                    inventoryDto.name(),
                    orderRequestDto.inventoryRequestDtoList() );
            orderInventoryEntity.setOrderId( order_id);
            orderInventoryEntity.setInventoryId( inventoryDto.id() );
            orderInventoryEntity.setQty(inventoryRequestDto.qty());
        }) ;

    }

    private static InventoryRequestDto getIventoryReqeustDtoByName(
            String inventory_name,
            List<InventoryRequestDto> inventoryInputDtoList
    )
    {
        return inventoryInputDtoList
                .stream()
                .filter(inventoryInputDto -> inventoryInputDto.inventoryName().equals(inventory_name))
                .findFirst()
                .orElse(null);
    }

    private OrderEntity save_order(OrderRequestDto orderRequestDto) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderIdentifier(UUID.randomUUID().toString());
        orderEntity.setCustomerName( orderRequestDto.customerName());
        orderEntity.setCustomerEmail( orderRequestDto.customerEmail());
        orderEntity.setStatus(OrderStatus.COMPLIETE);

        return orderRepository.save(orderEntity);
    }


//    public void breakTest() {
//        Optional<Inventory> savedInventory = inventoryRepository.getInventoryByName("data");
//        log.info( "inventory present: {}", savedInventory.isPresent() );
//    }

//    void test() {
//        String status = new Smart().convertToDatabaseColumn(OrderStatus.OPEN);
//        log.info("order status: {}", status);
//    }
}
