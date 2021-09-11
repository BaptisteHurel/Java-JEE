package com.formation.thyme.adapters;

import com.formation.thyme.dtos.CityDto;

import java.util.List;

public interface CityAdapter {
    List<CityDto> getAll();
    List<CityDto> getAllCapitals();
    CityDto getOne(Long id);
    CityDto save(CityDto city);
    CityDto update(CityDto city);
    void delete(Long id);
}
