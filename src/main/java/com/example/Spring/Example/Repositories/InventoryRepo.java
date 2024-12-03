package com.example.Spring.Example.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Spring.Example.Models.Film;
import com.example.Spring.Example.Models.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory, Integer> {
    List<Inventory> findByStore_StoreID(int storeID);
}
