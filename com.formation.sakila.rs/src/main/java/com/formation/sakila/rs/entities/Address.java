package com.formation.sakila.rs.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
    @Table(name="address")
public class Address {

    @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
            @Column(name="address_id")
    private Integer id;

    private String address;
    private String address2;
    private String district;
    private String postalCode;
    private String phone;
//    private Object location;
    private Timestamp lastUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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

   /* public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }
*/
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
