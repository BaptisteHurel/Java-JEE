package com.formation.sakila.rs.adapters;

import com.formation.sakila.rs.dtos.CountryDto;

import java.util.List;

public interface CountryAdapter {
    List<CountryDto> getAll();
    CountryDto getById(Long id);
    CountryDto create(CountryDto dto);
    CountryDto update(CountryDto dto);
    void delete(Long id);
}
