package com.formation.thyme.adapters;

import com.formation.thyme.dtos.CountryDto;
import com.formation.thyme.mappers.CountryMapper;
import com.formation.thyme.services.CountryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryAdapterImpl implements CountryAdapter {
    private CountryService service;

    public CountryAdapterImpl(CountryService service) {
        this.service = service;
    }

    @Override
    public List<CountryDto> getAll() {
        return service.findAll().stream().map(CountryMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CountryDto getOne(Long id) {
        return CountryMapper.toDto(service.findOne(id));
    }

    @Override
    public CountryDto update(CountryDto countryDto) {
        countryDto.setLastUpdate(LocalDateTime.now());
        return CountryMapper.toDto(service.update(CountryMapper.toDao(countryDto)));
    }

    @Override
    public CountryDto save(CountryDto countryDto) {
        return CountryMapper.toDto(service.save(CountryMapper.toDao(countryDto)));
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }

}
