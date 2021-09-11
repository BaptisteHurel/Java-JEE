package com.formation.sakila.rs.mappers;

import com.formation.sakila.rs.dtos.CityDto;
import com.formation.sakila.rs.entities.City;

public interface CityMapper {
    static CityDto toDto(City city){
        if ( city == null)
            return null;
        CityDto dto = new CityDto();
        dto.setCapital(city.getCapital());
        dto.setCountry(CountryMapper.toDto(city.getCountry()));
        dto.setId(city.getId());
        dto.setName(city.getCity());
        dto.setLastUpdate(city.getLastUpdate());
        return dto;
    }

    static City toDao(CityDto dto){
        City city = new City();
        city.setCity(dto.getName());
        city.setCapital(dto.getCapital());
        city.setCountry(CountryMapper.toDao(dto.getCountry()));
        city.setId(dto.getId());
        city.setLastUpdate(dto.getLastUpdate());
        return city;
    }
}
