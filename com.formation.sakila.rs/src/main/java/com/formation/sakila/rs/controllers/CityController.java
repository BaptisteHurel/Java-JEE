package com.formation.sakila.rs.controllers;

import com.formation.sakila.rs.adapters.CityAdapter;
import com.formation.sakila.rs.dtos.CityDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    @RequestMapping("/cities")
public class CityController {
    private final static Logger log = LoggerFactory.getLogger(CityController.class);

    private CityAdapter adapter;

    public CityController(CityAdapter adapter) {
        this.adapter = adapter;
    }

    @GetMapping("")
    public List<CityDto> getAll(){
        return adapter.getAll();
    }

    @GetMapping("/{id}")
    public CityDto getOne(@PathVariable Long id){
        log.info("Get on city id({})",id);
        return adapter.getOneById(id);
    }

}
