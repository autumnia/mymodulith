package com.autumnia.mymodulith.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {
    Optional<InventoryEntity> getInventoryByName(String name);
    List<InventoryEntity> getInventoryByNameIn(List<String> names);
}
