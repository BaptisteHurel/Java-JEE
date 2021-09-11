package com.formation.sakila.rs.services;


import com.formation.sakila.rs.entities.Actor;
import com.formation.sakila.rs.repositories.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService{
    private ActorRepository repository;

    public ActorServiceImpl(ActorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Actor> getAll() {
        return repository.findAll();
    }

    @Override
    public Actor getOneById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Actor add(Actor actor) {
        return repository.save(actor);
    }

}
