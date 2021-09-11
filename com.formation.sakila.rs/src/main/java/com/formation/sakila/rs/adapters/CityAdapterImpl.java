package com.formation.sakila.rs.adapters;

import com.formation.sakila.rs.dtos.CityDto;
import com.formation.sakila.rs.mappers.CityMapper;
import com.formation.sakila.rs.services.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityAdapterImpl implements CityAdapter{
    private final static Logger log = LoggerFactory.getLogger(CityAdapterImpl.class);
    private CityService service;

    public CityAdapterImpl(CityService service) {
        this.service = service;
    }


    @Override
    public List<CityDto> getAll() {
        return service.getAll().stream().map(c->CityMapper.toDto(c)).collect(Collectors.toList());
    }

    @Override
    public CityDto getOneById(Long id) {
        service.getById(id);
        return CityMapper.toDto(service.getById(id));
    }

    @Override
    public CityDto create(CityDto dto) {
        log.error("Not yet implemented ...");
        return null;
    }

    @Override
    public CityDto update(CityDto dto) {
        log.error("Not yet implemented ...");
        return null;
    }

    @Override
    public void delete(Long id) {
        log.error("Not yet implemented ...");
    }
}
