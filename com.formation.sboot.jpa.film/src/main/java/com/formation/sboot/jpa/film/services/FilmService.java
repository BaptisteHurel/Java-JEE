package com.formation.sboot.jpa.film.services;

import com.formation.sboot.jpa.film.entities.Film;

import java.math.BigDecimal;
import java.util.List;

public interface FilmService {
    Film getById(Long id);
    List<Film> getAll();
    List<Film> getAllByTitle(String title);
    List<Film> getMaxCostFilms();
    List<Object[]> getCountByRate();
}
