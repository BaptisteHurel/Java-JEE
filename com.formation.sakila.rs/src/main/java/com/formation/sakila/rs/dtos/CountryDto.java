package com.formation.sakila.rs.dtos;

import java.time.LocalDateTime;
import java.util.List;

/**
 * POJO
 */
public class CountryDto {
    private Long id;
    private String name;
    private LocalDateTime lastUpdate;
    private List<CityDto> cities;

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

    public List<CityDto> getCities() {
        return cities;
    }

    public CountryDto setCities(List<CityDto> cities) {
        this.cities = cities;
        return this;
    }

    @Override
    public String toString() {
        return "CountryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", cities=[...]" +
                '}';
    }
}
