package com.formation.thyme.services;

import com.formation.thyme.entities.Country;

import java.util.List;

public interface CountryService {
    List<Country> findAll() ;
    Country findOne(Long id) ;
    Country save(Country country) ;
    Country update(Country country) ;
    void delete(Long id);
}
