package com.formation.thyme.adapters;

import com.formation.thyme.dtos.CityDto;
import com.formation.thyme.mappers.CityMapper;
import com.formation.thyme.services.CityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityAdapterImpl implements CityAdapter {

    private CityService service;

    public CityAdapterImpl(CityService service) {
        this.service = service;
    }

    @Override
    public List<CityDto> getAll() {
        return service.readAll().stream().map(CityMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CityDto> getAllCapitals() {
        return service.allCapitals().stream().map(CityMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CityDto getOne(Long id) {
        return CityMapper.toDto(service.readById(id));
    }

    @Override
    public CityDto save(CityDto city) {
        return CityMapper.toDto(service.create(CityMapper.toDao(city)));
    }

    @Override
    public CityDto update(CityDto city) {
        return CityMapper.toDto(service.update(CityMapper.toDao(city)));
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }
}
