package com.formation.thyme.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
    @Table(name = "users")
public class User {
    @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @Column(name = "libelle")
    private String label;

    private String email;
    private Boolean enabled;

    @ManyToMany
        @JoinTable(name="roles",
                joinColumns={@JoinColumn(name="user_id")},
                inverseJoinColumns={@JoinColumn(name="rolename_id")})
        @JsonIgnoreProperties("users") // Break circular reference
    private List<RoleName> roles;


    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public User setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public User setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public List<RoleName> getRoles() {
        return roles;
    }

    public User setRoles(List<RoleName> roles) {
        this.roles = roles;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", label='" + label + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
