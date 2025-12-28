package com.autumnia.mymodulith.order.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.Instant;

@Data
@Entity
@Table(indexes ={
    @Index(name="ord_idx", columnList = "order_id"),
    @Index(name="inv_idx", columnList = "inventory_id")
})
public class OrderInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;
    private Long inventoryId;
    private int qty;
    private Long totalQtyPrice;
}
