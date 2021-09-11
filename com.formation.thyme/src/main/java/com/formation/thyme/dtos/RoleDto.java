package com.formation.thyme.dtos;

import javax.validation.constraints.NotBlank;

public class RoleDto  {
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String label;

    private Boolean activated;

    public Long getId() {
        return id;
    }

    public RoleDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RoleDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public RoleDto setLabel(String label) {
        this.label = label;
        return this;
    }

    public Boolean getActivated() {
        return activated;
    }

    public RoleDto setActivated(Boolean activated) {
        this.activated = activated;
        return this;
    }

    @Override
    public String toString() {
        return "RoleDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", label='" + label + '\'' +
                ", activated=" + activated +
                '}';
    }
}
