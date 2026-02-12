package com.autumnia.mymodulith.order;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(indexes ={
    @Index(name="ord_idx", columnList = "order_id"),
    @Index(name="inv_idx", columnList = "inventory_id")
})
public class OrderInventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long orderId;
    private long inventoryId;
    private int qty;
    private long totalQtyPrice;
}
