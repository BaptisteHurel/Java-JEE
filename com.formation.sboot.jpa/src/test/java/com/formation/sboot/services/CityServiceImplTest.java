package com.formation.sboot.services;

import com.formation.sboot.entities.City;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CityServiceImplTest {

    private final static Logger log = LoggerFactory.getLogger(CityServiceImplTest.class);

    @Autowired
    CityService service;

    @BeforeEach
    void setUp() {
        log.info("Before Each");
    }

    @Test
    void getAllByCountryId() {
        log.trace("<<<<START getAllByCountryId>>>>");
        Long countryId = 108L;
        int numberOfCities = 2;
        /** var cities = service.getAllByCountryId(countryId);
        assertTrue(cities.size()==numberOfCities,"ERROR Number of Cities is Wrong !!!!");
        cities.forEach(city -> log.trace("{}",city));
        log.trace("Number of founded cities : {}",cities.size());
        */
        log.trace("<<<<END   getAllByCountryId>>>>");
    }


}
