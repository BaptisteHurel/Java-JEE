package com.formation.sakila.rs.services;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CountryServiceImplTest {

    private final static Logger log = LoggerFactory.getLogger(CountryServiceImplTest.class);

    @Autowired
    CountryService service;

    @Test
        @Transactional
    void getAll() {
        assertNotNull(service,"Service Country NOT Injected !!!");
        log.info("<<<<<START getAll>>>>>");
        var countries = service.getAll();
        countries.forEach(c->log.trace("{}",c));
        countries.forEach(c-> {
            log.trace("{}", c);
            c.getCities().forEach(cy->log.trace("{}",cy));
        });
        log.info("Total number of countries :{}",countries.size());
        log.info("<<<<<END getAll>>>>>");
    }

    @Test
    void getAllNameLike() {
        log.info("<<<<<START getAllNameLike>>>>>");
        String like = "United" ;
        var countries = service.getAllNameLike(like);
        countries.forEach(c-> {
            log.trace("{}", c);
            c.getCities().forEach(cy->log.trace("{}",cy));
        });

        log.info("Total number of countries with name like ({}) :{}",like,countries.size());
        log.info("<<<<<END   getAllNameLike>>>>>");
    }

    @Test
    void getById() {
        log.info("<<<<<START getBy ID>>>>>");
        Long id = 103L;
        var country = service.getById(id);
        log.info("Country founded : {} ",country);
        log.trace("----------CITIES---------");
        var cities = country.getCities();
        cities.forEach(c->log.trace("{}",c));
        log.info("Total number of cities founded : {} ",cities.size());
        log.info("<<<<<END   getBy ID>>>>>");
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}