package com.example.Spring.Example.Models;

import jakarta.persistence.*;

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
    public Address() {
    }

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

    @Override
    public String toString() {
        return "Address [addressID=" + addressID + ", address=" + address + ", district=" + district + ", cityID="
                + cityID + ", postalCode=" + postalCode + ", phone=" + phone + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((addressID == null) ? 0 : addressID.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((district == null) ? 0 : district.hashCode());
        result = prime * result + ((cityID == null) ? 0 : cityID.hashCode());
        result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
        result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
        Address other = (Address) obj;
        if (addressID == null) {
            if (other.addressID != null)
                return false;
        } else if (!addressID.equals(other.addressID))
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (district == null) {
            if (other.district != null)
                return false;
        } else if (!district.equals(other.district))
            return false;
        if (cityID == null) {
            if (other.cityID != null)
                return false;
        } else if (!cityID.equals(other.cityID))
            return false;
        if (postalCode == null) {
            if (other.postalCode != null)
                return false;
        } else if (!postalCode.equals(other.postalCode))
            return false;
        if (phone == null) {
            if (other.phone != null)
                return false;
        } else if (!phone.equals(other.phone))
            return false;
        return true;
    }
}
