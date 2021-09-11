package com.formation.thyme.mappers;

import com.formation.thyme.dtos.CountryDto;
import com.formation.thyme.entities.Country;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public interface CountryMapper {
    public static Country toDao(CountryDto dto){
        if ( dto != null ) {
            Country country = new Country();
            country.setCountry(dto.getName());
            country.setId(dto.getId());
            country.setLastUpdate(dto.getLastUpdate()!=null?dto.getLastUpdate(): LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
            return country;
        }else
            return null;
    }

    public static CountryDto toDto(Country dao){
        if ( dao != null ) {
            CountryDto dto = new CountryDto();
            dto.setId(dao.getId());
            dto.setName(dao.getCountry());
            dto.setLastUpdate(dao.getLastUpdate());
            return dto;
        }else
            return null;
    }
}
