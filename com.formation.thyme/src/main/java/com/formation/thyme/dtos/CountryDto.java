package com.formation.thyme.dtos;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class CountryDto {
    private Long id;
    @NotBlank
    private String name;
    private LocalDateTime lastUpdate;

    public Long getId() {
        return id;
    }

    public CountryDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CountryDto setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public CountryDto setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    @Override
    public String toString() {
        return "CountryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
