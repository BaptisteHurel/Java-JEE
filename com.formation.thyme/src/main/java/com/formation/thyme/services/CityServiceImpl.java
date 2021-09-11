package com.formation.thyme.services;

import com.formation.thyme.entities.City;
import com.formation.thyme.repositories.CityRepository;
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
    public City create(City city) {
        return repository.save(city);
    }

    @Override
    public City readById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public City update(City city) {
        return repository.saveAndFlush(city);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<City> readAll() {
        return repository.findAll();
    }

    @Override
    public List<City> allCapitals() {
        return repository.findAllByCapitalIsTrue();
    }
}
