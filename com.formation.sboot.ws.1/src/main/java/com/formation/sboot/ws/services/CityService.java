package com.formation.sboot.ws.services;

import com.formation.sboot.ws.entities.City;

import java.util.List;

public interface CityService {
     public City getById(Long id);
     public List<City> getAll();
     public List<City> getAllCapitals();
     public List<City> getAllLikeName(String like);
}
