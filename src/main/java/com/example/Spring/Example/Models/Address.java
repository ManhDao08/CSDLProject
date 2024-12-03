package com.example.Spring.Example.Models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tblAddress")  // Đặt tên bảng trong cơ sở dữ liệu
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Tự động tăng ID
    @Column(name = "address_id")
    private Long addressID;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name = "district", length = 155)
    private String district;

    @Column(name = "city_id", nullable = false, length = 100)
    private String cityID;

    @Column(name = "postal_code", length = 15)
    private String postalCode;

    @Column(name = "phone", length = 25)
    private String phone;

    // Constructor mặc định (cần thiết cho Hibernate)
    public Address() {}

    // Constructor đầy đủ
    public Address(String address, String district, String cityID, String postalCode, String phone) {
        this.address = address;
        this.district = district;
        this.cityID = cityID;
        this.postalCode = postalCode;
        this.phone = phone;
        
    }

    // Getters and Setters
    public Long getAddressId() {
        return addressID;
    }

    public void setAddressId(Long addressId) {
        this.addressID = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return cityID;
    }

    public void setCity(String city) {
        this.cityID = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

   
}
