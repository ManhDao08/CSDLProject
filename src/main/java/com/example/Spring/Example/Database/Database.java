package com.example.Spring.Example.Database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Spring.Example.Models.Address;
import com.example.Spring.Example.Models.Product;
import com.example.Spring.Example.Models.Store;
import com.example.Spring.Example.Repositories.*;

@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(ProductRepo productRepo, AddressRepo addressRepo, StoreRepo storeRepo) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product product1 = new Product("Iphone", "Smartphone", null, null, 100, 100000, 10000000);
                // Product product2 = new Product("Laptop", "Computer", null, null, 100, 100000, 10000000);
                // logger.info("insert data: " + productRepo.save(product1));
                // logger.info("insert data: " + productRepo.save(product2));
                Address address = addressRepo.findById(1L).orElse(null);
                if (address != null) {
                    // Khởi tạo store với địa chỉ hợp lệ
                    // address = entityManager.merge(address);
                    Store store1 = new Store();
                    store1.setAddressID(address); // Gán địa chỉ vào store
                    store1.setManagerStaffID(1);
                    storeRepo.save(store1);  // Lưu store vào cơ sở dữ liệu
                }
        };
    };
}
}
