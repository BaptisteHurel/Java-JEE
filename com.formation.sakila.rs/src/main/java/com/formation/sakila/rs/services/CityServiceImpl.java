package com.formation.sakila.rs.services;

import com.formation.sakila.rs.entities.City;
import com.formation.sakila.rs.repositories.CityRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{

    private final static Logger log = LoggerFactory.getLogger(CityServiceImpl.class);
    private CityRepository repository;

    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public City getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public City create(City city) {
        return repository.save(city);
    }

    @Override
    public List<City> getAll() {
        return repository.findAll();
    }

    @Override
    public List<City> getAllCapitals() {
        return repository.findAllByCapitalIsTrue();
    }

    @Override
    public List<City> getAllLikeName(String like) {
        return repository.findAllByCityContains(like);
    }

}
