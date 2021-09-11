package com.formation.sboot.jpa.film.repositories;

import com.formation.sboot.jpa.film.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language,Long> {
}
