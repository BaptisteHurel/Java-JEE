package com.formation.thyme.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
    @Table(name = "role_name")
        @JsonIgnoreProperties("users")
public class RoleName {
    @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    public RoleName(){}

    public RoleName(Long id) {
        this.id = id;
    }

    @Column(name = "libelle")
    private String label;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Long getId() {
        return id;
    }

    public RoleName setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RoleName setName(String name) {
        this.name = name;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public RoleName setLabel(String label) {
        this.label = label;
        return this;
    }

    public List<User> getUsers() {
        return users;
    }

    public RoleName setUsers(List<User> users) {
        this.users = users;
        return this;
    }

    @Override
    public String toString() {
        return "RoleName{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
