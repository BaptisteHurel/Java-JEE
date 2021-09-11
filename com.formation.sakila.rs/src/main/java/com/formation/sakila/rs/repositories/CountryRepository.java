package com.formation.sakila.rs.repositories;

import com.formation.sakila.rs.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country,Long>, CountryRepositoryCustom<Country,Long> {
    List<Country> findAllByCountryContains(String name);
}
