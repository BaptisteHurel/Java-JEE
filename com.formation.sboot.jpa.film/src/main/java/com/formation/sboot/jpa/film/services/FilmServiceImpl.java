package com.formation.sboot.jpa.film.services;

import com.formation.sboot.jpa.film.entities.Film;
import com.formation.sboot.jpa.film.repositories.FilmRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.math.BigDecimal;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService{
    private final static Logger log = LoggerFactory.getLogger(FilmServiceImpl.class);
    private FilmRepository repository;

    private EntityManager entityManager;

    public FilmServiceImpl(FilmRepository repository, EntityManager entityManager) {
        this.repository = repository;
        this.entityManager = entityManager;
    }

    @Override
    public Film getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Film> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Film> getAllByTitle(String title) {
        return repository.getALlByTitleContains(title);
    }

    /**
     * Sub query example :
     * select * from film
     *    where replacement_cost = ( select  max(replacement_cost)  from film);
     *
     * @return : List of films with high replacement cost (29.99)
     */
    @Override
    public List<Film> getMaxCostFilms() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Film> criteriaQuery =
                cb.createQuery(Film.class);
        Root<Film> films = criteriaQuery.from(Film.class);

        Subquery<BigDecimal> maxCost = criteriaQuery.subquery(BigDecimal.class);
        Root<Film> subFilm = maxCost.from(Film.class);

        var maxq = maxCost.select(cb.max(subFilm.get("replacementCost")));

        var criteria =
                criteriaQuery
                        .select(films)
                        .where(cb.equal(films.get("replacementCost"),maxq));

        return entityManager.createQuery(criteria).getResultList();
    }

    @Override
    public List<Object[]> getCountByRate(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery =
                cb.createQuery(Object[].class);
        Root<Film> films = criteriaQuery.from(Film.class);

        var criteria = criteriaQuery.multiselect(films.get("rentalRate"),cb.count(films)).groupBy(films.get("rentalRate"));

        return entityManager.createQuery(criteria).getResultList();
    }

}
