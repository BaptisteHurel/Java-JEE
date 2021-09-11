package com.formation.sakila.rs.services;

import com.formation.sakila.rs.entities.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> getAll() ;
    Actor getOneById(Long id) ;
    Actor add(Actor actor) ;
}
