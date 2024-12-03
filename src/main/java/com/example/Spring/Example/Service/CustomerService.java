package com.example.Spring.Example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Spring.Example.Models.Customer;
import com.example.Spring.Example.Repositories.CustomerRepo;

@Service
public class CustomerService {

    @Autowired
    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }
    
    public Customer registerCustomer(Customer customer) {
        // if (firstName != null && lastName != null && email != null && password != null
        //     && !firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
        //         Customer customer = new Customer();
        //         customer.setFirstName(firstName);
        //         customer.setLastName(lastName);
        //         customer.setEmail(email);
        //         customer.setPassword(password);
        //         customer.setActive(true);
        //         return customerRepo.save(customer);
        //     }
        return customerRepo.save(customer);
    }

    public Customer authenticate(String email, String password) {
        return customerRepo.findByEmailAndPassword(email, password).orElse(null);
    }
}
