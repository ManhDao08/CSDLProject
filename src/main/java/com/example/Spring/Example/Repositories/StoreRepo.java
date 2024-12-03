package com.example.Spring.Example.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Spring.Example.Models.*;

public interface StoreRepo extends JpaRepository<Store, Integer> {

    
} 
