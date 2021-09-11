package com.formation.sakila.rs.repositories;

import com.formation.sakila.rs.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
