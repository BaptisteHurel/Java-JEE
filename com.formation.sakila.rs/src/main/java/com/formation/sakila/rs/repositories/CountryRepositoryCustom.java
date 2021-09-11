package com.formation.sakila.rs.repositories;

import java.util.Optional;

public interface CountryRepositoryCustom<T,K> {
    Optional<T> findById(K id);
}
