package com.formation.sboot.repositories;

import com.formation.sboot.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    //@Query("from City where country.id = ?1")
    //List<City> findCitiesByCountryId(Long countryId);
}
