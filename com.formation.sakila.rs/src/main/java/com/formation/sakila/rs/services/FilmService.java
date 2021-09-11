package com.formation.sakila.rs.services;

import com.formation.sakila.rs.entities.Film;

import java.util.List;

public interface FilmService {
    List<Film> getAll();
    Film getById(Long id);
    List<Film> getAllByLanguageId(Long languageId);
}
