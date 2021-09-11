package com.formation.sakila.rs.adapters;

import com.formation.sakila.rs.dtos.CountryDto;
import com.formation.sakila.rs.mappers.CountryMapper;
import com.formation.sakila.rs.services.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryAdapterImpl implements CountryAdapter{
    private final static Logger log = LoggerFactory.getLogger(CountryAdapterImpl.class);

    CountryService service;

    public CountryAdapterImpl(CountryService service) {
        this.service = service;
    }

    @Override
    public List<CountryDto> getAll() {
        var countries = service.getAll();
        var res = countries.stream()
                .map(country -> CountryMapper.toDto(country))
                .collect(Collectors.toList());
        return res;
    }

    @Override
    public CountryDto getById(Long id) {
        var country = service.getById(id);
        return CountryMapper.toDtoWithCities(country);
    }

    @Override
    public CountryDto create(CountryDto dto) {
        log.error("Not yet implemented ...");
        return null;
    }


    @Override
    public CountryDto update(CountryDto dto) {
        log.error("Not yet implemented ...");
        return null;
    }

    @Override
    public void delete(Long id) {
        log.error("Not yet implemented ...");
    }
}
