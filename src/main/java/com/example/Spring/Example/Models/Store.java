package com.example.Spring.Example.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    public Store() {
    }

    public Store(int storeID, int managerStaffID) {
        this.storeID = storeID;
        this.managerStaffID = managerStaffID;
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

    public Address getAddressID() {
        return this.address;
    }

    public void setAddressID(Address address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + storeID;
        result = prime * result + managerStaffID;
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
        if (address != other.address)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Store [storeID=" + storeID + ", managerStaffID=" + managerStaffID + ", addressID=" + address.getAddressId() + "]";
    }
    
}
