package com.autumnia.mymodulith.inventory;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="inventory")
//@Table(indexes = @Index(name="ivn_name_idx", columnList = "name"))
public class InventoryEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    private long price;
}
