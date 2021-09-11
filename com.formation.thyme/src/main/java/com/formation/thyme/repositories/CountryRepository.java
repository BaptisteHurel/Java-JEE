package com.formation.thyme.repositories;

import com.formation.thyme.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {

    @Query("from Country where country like %?1%")
    List<Country> findNameLike(String name);

    List<Country> findAllByLastUpdateAfter(LocalDateTime date);
}
