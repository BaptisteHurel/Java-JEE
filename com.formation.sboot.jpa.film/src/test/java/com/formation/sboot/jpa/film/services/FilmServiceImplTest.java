package com.formation.sboot.jpa.film.services;

import com.formation.sboot.jpa.film.entities.Film;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FilmServiceImplTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    FilmService service;

    private final static Logger log = LoggerFactory.getLogger(FilmServiceImplTest.class);
    @BeforeEach
    void setUp() {
        assertNotNull(entityManager,"ENTITY MANAGER NOT INJECTED !!!!");
    }

    @Test
        @DisplayName("Test get one film by Id")
            @Order(2)
    void testGetOneFilmById() {
        Long filmId = 358L;
        var film = service.getById(filmId);
        log.trace("{}",film);
    }

    @Test
        @DisplayName("Test get All Films")
            @Order(1)
    void getAll() {
        log.info("<<<<START Get All Film>>>>");
        service.getAll().forEach(film -> log.trace("{}",film));
    }

    @Test
        @DisplayName("Test For Film with max remplacement cost")
            @Order(0)
    void testForFilmWithMaxRemplacementCost() {
        var maxCost = service.getAll().stream().map(Film::getReplacementCost).reduce(BigDecimal::max);
        log.trace("Prix Max :{}",maxCost);
    }

    @Test
    @DisplayName("Test Get Film with the maximum replacement cost")
    void testGetFilmWithTheMaximumReplacementCost() {
        var films = service.getMaxCostFilms();
        films.forEach(f->log.trace("{}",f));
        log.trace("Total films with max cost :{}",films.size());
    }

    @Test
    @DisplayName("Test get number of films by rate")
    void testGetNumberOfFilmsByRate() {
        var lists = service.getCountByRate();
        lists.forEach(o -> log.trace("{} : {} ",o[0],o[1]));
    }


    public class Exemple{
        private String key;
        private Integer value;
        Exemple(){}
        Exemple(String key, Integer value){
            this.key=key;
            this.value=value;
        }
        @Override
        public String toString() {
            return "Exemple{" +
                    "key='" + key + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

    @Test
    @DisplayName("Test for Mapp in Stream")
    void testForMappInStream() {
        List<Integer> list = Arrays.asList(3, 6, 9, 12, 15);
        list.stream().map(number -> number * 3).forEach(System.out::println);
        Exemple e = new Exemple();
        var l =list.stream().map(number -> new Exemple(String.valueOf(number)+"-",number*2));

        l.forEach(i->log.trace("{}",i));

    }

    @Test
        @DisplayName("Test All Films by Title")
    void testAllFilmsByTitle() {
        service.getAllByTitle("french").forEach(f->log.trace("{}",f));
    }


    @Test
        @DisplayName("Test for JPA Criteria")
    void testForJpaCriteria() {
        log.trace("<<<<<START Multi Criteria TESTS");

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Film> criteriaQuery = criteriaBuilder.createQuery(Film.class);
        Root<Film> root = criteriaQuery.from(Film.class);

        // Define all Criteria
        Predicate yearPredicate
                = criteriaBuilder.equal(root.get("releaseYear"), 2010);
        Predicate langPredicate
                = criteriaBuilder.equal(root.get("language").get("id"), 1);
        Predicate rentalPredicate
                = criteriaBuilder.equal(root.get("rentalRate"), BigDecimal.valueOf(0.99));

        var predicates =Arrays.asList(yearPredicate, langPredicate, rentalPredicate);

        // Add Criteria to AND
        Predicate allPredicate
                = criteriaBuilder.and(yearPredicate, langPredicate, rentalPredicate);

        // Complete WHERE clause
        criteriaQuery.where(allPredicate);

        // Submit QUERY

        var films = entityManager.createQuery(criteriaQuery).getResultList();

        log.trace("Number total of films :{}",films.size());
        log.trace("<<<<<END   Multi Criteria TESTS");
    }

}