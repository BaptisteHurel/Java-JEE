package com.formation.sboot.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.sboot.entities.Country;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country,Long> {

    @Query("from Country where country like %?1%")
    List<Country> findByNameLike(String nameLike);
}
