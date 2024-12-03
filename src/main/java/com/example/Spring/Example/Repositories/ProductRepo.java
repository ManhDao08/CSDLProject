package com.example.Spring.Example.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Spring.Example.Models.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByProductName(String productName);
}
