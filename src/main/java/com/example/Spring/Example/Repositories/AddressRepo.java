package com.example.Spring.Example.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Spring.Example.Models.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {
    
}
