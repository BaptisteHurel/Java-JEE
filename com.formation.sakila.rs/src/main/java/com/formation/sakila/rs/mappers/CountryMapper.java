package com.formation.sakila.rs.mappers;

import com.formation.sakila.rs.dtos.CountryDto;
import com.formation.sakila.rs.entities.Country;

import java.util.stream.Collectors;

public interface CountryMapper {
    static CountryDto toDto(Country country){
        if ( country == null)
            return null;
        CountryDto dto = new CountryDto();
        dto.setId(country.getId());
        dto.setLastUpdate(country.getLastUpdate());
        dto.setName(country.getCountry());
        return dto;
    }

    static Country toDao(CountryDto dto){
        Country country = new Country();
        country.setCountry(dto.getName());
        country.setId(dto.getId());
        country.setLastUpdate(dto.getLastUpdate());
        return country;
    }

    static CountryDto toDtoWithCities(Country country) {
        var dto = toDto(country);
        if ( dto == null)
            return null;

        dto.setCities(
                country.getCities().stream().map(c -> CityMapper.toDto(c)).collect(Collectors.toList()));
        return dto;
    }
}
