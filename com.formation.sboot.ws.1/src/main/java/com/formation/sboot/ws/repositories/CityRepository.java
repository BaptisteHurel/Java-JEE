package com.formation.sboot.ws.repositories;

import com.formation.sboot.ws.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findAllByCityContains(String like);
    List<City> findAllByCapitalIsTrue();
}
