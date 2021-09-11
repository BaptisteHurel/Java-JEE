package com.formation.sakila.rs.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

@Entity
    @Table(name = "staff")
public class Staff {
    @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
            @Column(name="staff_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    private String email ;
    private Boolean active;

    @Transient
    private byte[] picture;

    private String username;
    private String password;

    private Integer storeId;

    @ManyToOne
      @JoinColumn(name="address_id")
    private Address address;

/*    @OneToMany(fetch = FetchType.LAZY, mappedBy = "email", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Authority> roles;*/

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Staff.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("email='" + email + "'")
                .add("active=" + active)
                .add("picture=" + Arrays.toString(picture))
                .add("username='" + username + "'")
                .add("password='*******'")
                .add("lastUpdate=" + lastUpdate)
                .toString();
    }
}
