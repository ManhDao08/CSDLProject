package com.example.Spring.Example.Database;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Spring.Example.Models.Address;
import com.example.Spring.Example.Models.Film;
import com.example.Spring.Example.Models.Product;
import com.example.Spring.Example.Models.Staff;
import com.example.Spring.Example.Models.Store;
import com.example.Spring.Example.Repositories.*;

@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(ProductRepo productRepo, AddressRepo addressRepo, StoreRepo storeRepo, StaffRepo staffRepo) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                // Product product1 = new Product("Iphone", "Smartphone", null, null, 100, 100000, 10000000);
                // // Product product2 = new Product("Laptop", "Computer", null, null, 100, 100000, 10000000);
                // // logger.info("insert data: " + productRepo.save(product1));
                // // logger.info("insert data: " + productRepo.save(product2));
                // if (address != null) {
                //     // Khởi tạo store với địa chỉ hợp lệ
                //     // address = entityManager.merge(address);
                //     Store store1 = new Store();
                //     store1.setAddressID(address); // Gán địa chỉ vào store
                //     store1.setManagerStaffID(1);
                //     storeRepo.save(store1);  // Lưu store vào cơ sở dữ liệu

                    // Address address = addressRepo.findById(1L).orElse(null);
                    // Store store1 = storeRepo.findById(2).orElse(null);
                    // Staff staff = new Staff();
                    // staff.setFirstName("John");
                    // staff.setLastName("Doe");
                    // staff.setAddress(address);
                    // staff.setEmail("johndoe@example.com");
                    // staff.setStore(store1);
                    // staff.setActive(true);
                    // staff.setPassword("password123");
    
                    // // Lưu đối tượng Staff vào cơ sở dữ liệu
                    // staffRepo.save(staff);
                
                // Tạo đối tượng Store cho staff2
                // Store store2 = new Store();
                // store2.setAddressID(address2);
                // store2.setManagerStaffID(12332111);

                // storeRepo.save(store2);

                // for (int i = 0; i < 30; i++) {
                //     Address address2 = new Address();
                //     address2.setAddress("123456 Oak Avenue");
                //     address2.setCity("Da Nang 1");

                //     addressRepo.save(address2);
                //     Store store2 = storeRepo.findById(2).orElse(null);
                //     Staff staff2 = new Staff();
                //     staff2.setFirstName("Jane1");
                //     staff2.setLastName("Smith11");
                //     staff2.setEmail("jane1.smith11@example.com");
                //     staff2.setAddress(address2);  // Liên kết với Address
                //     staff2.setStore(store2);      // Liên kết với Store
                //     staff2.setActive(true);
                //     staff2.setPassword("anotherpassword123");
                //     staffRepo.save(staff2);
                // }

                // System.out.println(staff2.getStaffID());

                // // Lưu Staff thứ hai vào cơ sở dữ liệu
                // staffRepo.save(staff2);

            };
                
    };
}
}
