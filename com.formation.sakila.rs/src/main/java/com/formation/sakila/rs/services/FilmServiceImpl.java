package com.formation.sakila.rs.services;

import com.formation.sakila.rs.entities.Film;
import com.formation.sakila.rs.repositories.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService{

    private FilmRepository repository;

    public FilmServiceImpl(FilmRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Film> getAll() {
        return repository.findAll();
    }

    @Override
    public Film getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Film> getAllByLanguageId(Long languageId) {
        return repository.findAllByLanguageId(languageId);
    }
}
