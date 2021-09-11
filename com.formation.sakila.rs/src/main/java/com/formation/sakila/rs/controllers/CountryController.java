package com.formation.sakila.rs.controllers;

import com.formation.sakila.rs.adapters.CountryAdapter;
import com.formation.sakila.rs.dtos.CountryDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    @RequestMapping("/countries")
public class CountryController {
    private final static Logger log = LoggerFactory.getLogger(CountryController.class);

    private CountryAdapter adapter;

    public CountryController(CountryAdapter adapter) {
        this.adapter = adapter;
    }

    @GetMapping({"","/all"})
    public List<CountryDto> getAll(){
        log.trace("Get All Countries called (adapter) ...");
        return adapter.getAll();
    }

    @GetMapping("/{id}")
    public CountryDto getById(@PathVariable Long id){
        log.trace("Get by Id called :{}",id);
        return adapter.getById(id);
    }


}
