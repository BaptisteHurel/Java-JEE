package com.formation.sakila.rs.repositories;

import com.formation.sakila.rs.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film,Long> {
    List<Film> findAllByLanguageId(Long languageId);
}
