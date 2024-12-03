package com.example.Spring.Example.Service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.*;

import com.example.Spring.Example.Models.*;
import com.example.Spring.Example.Repositories.*;

@Service
public class StoreService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private StaffRepo staffRepo;

    @Autowired
    private InventoryRepo inventoryRepo;

    public List<Film> getFilmsByStore(int storeId) {
        List<Inventory> inventories = inventoryRepo.findByStore_StoreID(storeId);
        List<Film> films = new ArrayList<>();
        for (Inventory i : inventories) {
            films.add(i.getFilm());
        }  
        return films;
    }

    public List<Customer> getCustomersByStore(int storeId) {
        return customerRepo.findByStore_StoreID(storeId);  
    }

    public List<Staff> getStaffByStore(int storeId) {
        return staffRepo.findByStore_StoreID(storeId);  
    }
}

