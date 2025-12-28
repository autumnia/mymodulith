package com.autumnia.mymodulith.inventory.repository;

import com.autumnia.mymodulith.inventory.entity.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long> {
    Optional<Inventory> getInventoryByName(String name);
    List<Inventory> getInventoryByNameIn(List<String> names);
}
