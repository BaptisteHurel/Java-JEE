package com.formation.sboot.services;

import com.formation.sboot.entities.City;
import com.formation.sboot.repositories.CityRepository;
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
    public List<City> getAll() {
        return repository.findAll();
    }

}

