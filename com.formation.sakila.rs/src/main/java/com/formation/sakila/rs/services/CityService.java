package com.formation.sakila.rs.services;

import com.formation.sakila.rs.entities.City;

import java.util.List;

public interface CityService {
     public City getById(Long id);
     public City create(City city);
     public List<City> getAll();
     public List<City> getAllCapitals();
     public List<City> getAllLikeName(String like);
}
