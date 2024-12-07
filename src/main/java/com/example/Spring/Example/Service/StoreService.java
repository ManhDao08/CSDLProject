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

    @Autowired
    private FilmRepo filmRepo;

    @Autowired
    private LanguageRepo languageRepo;

    @Autowired
    private AddressRepo addressRepo;

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

    public void addFilm(Film film, Store store) {
        try {
            Language language = film.getLanguage();
            List<Language> names = languageRepo.findByName(language.getName());
            Language oriLanguage = film.getOriginalLanguage();
            List<Language> oriNames = languageRepo.findByName(oriLanguage.getName());
            if (names == null || names.isEmpty()) {
                languageRepo.save(language);
            } else {
                film.setLanguage(names.get(0));
            }
            if (oriNames == null || oriNames.isEmpty()) {
                languageRepo.save(oriNames.get(0));
            } else {
                film.setOriginalLanguage(oriNames.get(0));
            }
            filmRepo.save(film);
            Inventory newInventory = new Inventory();
            newInventory.setFilm(film);
            newInventory.setStore(store);
            inventoryRepo.save(newInventory);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void addStaff(Staff staff) {
        try {
            Address address = staff.getAddress();
            addressRepo.save(address);
            staffRepo.save(staff);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void addCustomer(Customer customer) {
        try {
            Address address = customer.getAddress();
            addressRepo.save(address);
            customerRepo.save(customer);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}

