package com.example.Spring.Example.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Spring.Example.Models.Staff;

@Repository
public interface StaffRepo extends JpaRepository<Staff, Integer> {
    List<Staff> findByStore_StoreID(int storeId);
    Optional<Staff> findByEmailAndPassword(String email, String password);
}
