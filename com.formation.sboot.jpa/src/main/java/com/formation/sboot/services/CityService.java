package com.formation.sboot.services;

import com.formation.sboot.entities.City;

import java.util.List;

public interface CityService {
    public City getById(Long id);
    public List<City> getAll();
}
