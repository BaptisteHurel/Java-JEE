package com.formation.sboot.jpa.film.repositories;

import com.formation.sboot.jpa.film.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {
    public List<Film> getALlByTitleContains(String title);
}
