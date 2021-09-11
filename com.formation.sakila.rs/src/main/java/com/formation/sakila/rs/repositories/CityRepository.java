package com.formation.sakila.rs.repositories;

import com.formation.sakila.rs.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findAllByCityContains(String like);
    List<City> findAllByCapitalIsTrue();
}
