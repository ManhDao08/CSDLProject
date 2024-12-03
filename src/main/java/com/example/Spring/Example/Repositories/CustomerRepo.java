package com.example.Spring.Example.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Spring.Example.Models.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByEmailAndPassword(String email, String password);
    List<Customer> findByStore_StoreID(int storeId);

}
