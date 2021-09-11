package com.formation.thyme.services;

import com.formation.thyme.entities.City;

import java.util.List;

public interface CityService {
    City create(City city);
    City readById(Long id);
    City update(City city);
    void delete(Long id);
    List<City> readAll();
    List<City> allCapitals();
}
