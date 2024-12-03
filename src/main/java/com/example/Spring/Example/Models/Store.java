package com.example.Spring.Example.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tblStore")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private int storeID;

    @Column(name = "manager_staff_id")
    private int managerStaffID;

    @Column(name = "address_id")
    private int addressID;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Customer> customers = new ArrayList<>();

    public Store() {
    }

    public Store(int storeID, int managerStaffID, int addressID) {
        this.storeID = storeID;
        this.managerStaffID = managerStaffID;
        this.addressID = addressID;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public int getManagerStaffID() {
        return managerStaffID;
    }

    public void setManagerStaffID(int managerStaffID) {
        this.managerStaffID = managerStaffID;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + storeID;
        result = prime * result + managerStaffID;
        result = prime * result + addressID;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Store other = (Store) obj;
        if (storeID != other.storeID)
            return false;
        if (managerStaffID != other.managerStaffID)
            return false;
        if (addressID != other.addressID)
            return false;
        return true;
    }

    public List<Customer> getCustomers() {
        return customers;
    }


    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        customer.setStore(this); // Đảm bảo mối quan hệ nghịch
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
        customer.setStore(null); // Hủy liên kết nghịch
    }

    @Override
    public String toString() {
        return "Store [storeID=" + storeID + ", managerStaffID=" + managerStaffID + ", addressID=" + addressID + "]";
    }
    
}
