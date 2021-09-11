package com.formation.sakila.rs.dtos;

import java.time.LocalDateTime;

public class CityDto {
    private Long id;
    private String name;
    private Boolean capital;
    private CountryDto country;
    private LocalDateTime lastUpdate;

    public Long getId() {
        return id;
    }

    public CityDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CityDto setName(String name) {
        this.name = name;
        return this;
    }

    public Boolean getCapital() {
        return capital;
    }

    public CityDto setCapital(Boolean capital) {
        this.capital = capital;
        return this;
    }

    public CountryDto getCountry() {
        return country;
    }

    public CityDto setCountry(CountryDto country) {
        this.country = country;
        return this;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public CityDto setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    @Override
    public String toString() {
        return "CityDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capital=" + capital +
                ", country=" + country +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
