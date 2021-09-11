package com.formation.thyme.services;

import com.formation.thyme.entities.Country;
import com.formation.thyme.repositories.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{
    private final static Logger log = LoggerFactory.getLogger(CountryServiceImpl.class);

    private CountryRepository repository;

    public CountryServiceImpl(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Country> findAll() {
        return repository.findAll();
    }

    @Override
    public Country findOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Country save(Country country) {
        return repository.save(country);
    }

    @Override
    public Country update(Country country) {
        return repository.saveAndFlush(country);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
