package com.formation.sboot.ws.mappers;

import com.formation.sboot.soap.CountryType;
import com.formation.sboot.ws.entities.Country;

import java.time.LocalDateTime;

public interface CountryMapper {
    public static CountryType toType(Country country){
        CountryType type = new CountryType();
        type.setId(country.getId().intValue());
        type.setName(country.getCountry());
        type.setLastUpdate(country.getLastUpdate().toString());
        return type;
    }

    public static Country toDao(CountryType type){
        Country country = new Country();
        country.setCountry(type.getName());
        country.setId((long) type.getId());
        country.setLastUpdate(LocalDateTime.parse(type.getLastUpdate()));
        return country;
    }
}
