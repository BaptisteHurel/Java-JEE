package com.formation.sakila.rs.repositories;

import com.formation.sakila.rs.entities.Country;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

public class CountryRepositoryCustomImpl implements CountryRepositoryCustom<Country,Long> {
    private final static Logger log = LoggerFactory.getLogger(CountryRepositoryCustomImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<Country> findById(Long id) {
        log.trace("findById CUSTOMIZED");
        var country = em.find(Country.class, id);
        if ( country != null )
            Hibernate.initialize(country.getCities());
        return Optional.ofNullable(country);
    }
}
