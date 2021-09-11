package com.formation.thyme.adapters;

import com.formation.thyme.dtos.CountryDto;

import java.util.List;

public interface CountryAdapter {
    List<CountryDto> getAll();
    CountryDto getOne(Long id);
    CountryDto update(CountryDto countryDto);
    CountryDto save(CountryDto countryDto);
    void delete(Long id);
}
