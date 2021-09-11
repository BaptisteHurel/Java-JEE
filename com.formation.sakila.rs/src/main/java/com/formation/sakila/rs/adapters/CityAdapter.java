package com.formation.sakila.rs.adapters;

import com.formation.sakila.rs.dtos.CityDto;

import java.util.List;

public interface CityAdapter {
    List<CityDto> getAll();
    CityDto getOneById(Long id);
    CityDto create(CityDto dto);
    CityDto update(CityDto dto);
    void delete(Long id);
}
