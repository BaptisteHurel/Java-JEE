package com.formation.thyme.mappers;


import com.formation.thyme.dtos.CityDto;
import com.formation.thyme.dtos.CountryDto;
import com.formation.thyme.entities.City;
import com.formation.thyme.entities.Country;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public interface CityMapper {
    public static CityDto toDto(City city){
        CityDto cityDto = new CityDto();
        cityDto.setId(city.getId());
        cityDto.setName(city.getCity());
        cityDto.setCapital(city.getCapital());
        CountryDto cdto = new CountryDto();
        cdto.setId(city.getCountry().getId());
        cdto.setName(city.getCountry().getCountry());
        cdto.setLastUpdate(city.getCountry().getLastUpdate());
        cityDto.setCountry(cdto);
        cityDto.setLastUpdate(city.getLastUpdate());
        return cityDto;
    }

    public static City toDao(CityDto dto){
        City city = new City();
        city.setId(dto.getId());
        city.setCity(dto.getName());
        city.setCapital(dto.getCapital());
        Country country = new Country();
        country.setId(dto.getCountry().getId());
        city.setCountry(country);
        city.setLastUpdate(dto.getLastUpdate()!=null?dto.getLastUpdate(): LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        return city;
    }

}
