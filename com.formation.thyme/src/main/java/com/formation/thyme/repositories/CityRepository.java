package com.formation.thyme.repositories;

import com.formation.thyme.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findAllByCapitalIsTrue();
}
