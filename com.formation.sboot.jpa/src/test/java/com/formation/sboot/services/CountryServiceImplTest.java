package com.formation.sboot.services;

import com.formation.sboot.entities.Country;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CountryServiceImplTest {

    private final static Logger log = LoggerFactory.getLogger(CountryServiceImplTest.class);

    private final static long NUMBER_OF_COUNTRY = 117L;

    @Autowired
    CountryService countryService;

    // Create Object to chain CRUD Operations
    static Country countrySaved;

    @BeforeEach
    void setUp() {
        log.trace("Before Each");
    }

    @Test
    @Disabled
    void getAll() {
        log.info("START getAll TEST");
        List<Country> countries = countryService.getAll();
        // Abort if total number of country NOT equal to expected value (NUMBER_OF_COUNTRY)
        assertEquals(NUMBER_OF_COUNTRY, countries.size(), "ERROR Number of countries must be :" + NUMBER_OF_COUNTRY + " found :" + countries.size());
        log.info("Total number of countries : {}",countries.size());
        for ( Country c : countries){
            log.trace("{}", c);
        }
        log.info("END   getAll TEST");
    }

    @Test
    @Disabled
    @Transactional
    void testGetById(){
        log.info("START testGetById TEST");
        //
        // Creation Object à comparer
        //
        Country countryExpected = new Country();
        countryExpected.setCountry("Yugoslavia");
        countryExpected.setId(108L);
        countryExpected.setLastUpdate(LocalDateTime.parse("2006-02-15T04:44:00"));
        //
        // Lecture de l'objet dans la base
        //
        Long countryId = 108L;
        Country country = countryService.getById(countryId);
        assertNotNull(country,"ERROR Country Id("+countryId+") NOT FOUND !!!");
        log.info("Country Id:{} founded = {}",countryId, country);
        //assertEquals(countryExpected,country,"ERROR Country NOT Equal to DB Occurence");
        assertTrue(countryExpected.equals(country),"ERROR Country NOT Equal to DB Occurence");
        // GetCities() Control
        var cities = country.getCities();
        cities.forEach(city -> log.trace("{}",city));
        log.trace("Number of cities for {} : {} ",country.getCountry(),cities.size());
        log.info("END   testGetById TEST");
    }

    @Test
    @Order(0)
    void createCountry(){
        log.info("START Create Country");
        Country countryExpected = new Country();
        countryExpected.setCountry("XXXX-TEST-INTEGRATION-XXXX");
        countryExpected.setLastUpdate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        countrySaved = countryService.create(countryExpected);
        assertNotNull(countryExpected.getId(),"ERROR While CREATE Country Operation");
        log.info("AFTER CREATION Country :{}",countryExpected);
        log.info("END   Create Country");
    }

    @Test
    @Order(1)
    void readCountry(){
        log.info("START Read Country");
        assertNotNull(countrySaved,"ERROR While Read Country Operation countrySaved is NULL !!!");
        Country country = countryService.getById(countrySaved.getId());
        assertEquals(countrySaved, country,"ERROR On Read OPERATION Object are NOT Equals");
        log.trace("Country AFTER Read :{}", country);
        log.info("END   Read Country");
    }

    @Test
    @Order(2)
    void updateCountry(){
        log.info("START Update Country");
        assertNotNull(countrySaved,"ERROR While Update Country Operation countrySaved is NULL !!!");
        Country country = countryService.getById(countrySaved.getId());
        country.setCountry(country.getCountry()+" --MODIFIED--");
        countryService.update(country);
        Country compare = countryService.getById(countrySaved.getId());
        assertTrue(compare.getCountry().endsWith("--MODIFIED--"));
        log.info("END   Update Country");
    }

    @Test
    @Order(3)
    void deleteCountry(){
        log.info("START Delete Country");
        assertNotNull(countrySaved,"ERROR While Update Country Operation countrySaved is NULL !!!");
        countryService.delete(countrySaved.getId());
        assertNull(countryService.getById(countrySaved.getId()),"ERROR While DELETE Operation on Country");
        log.info("END   Delete Country");
    }

    @Test
    void testFindLikeName(){
        log.info("START testFindLikeName ");
        String like = "United" ;
        List<Country> countries = countryService.getAllNameLike(like);
        assertEquals(3, countries.size(),"ERROR Like Request on Countries with ("+like+") must return 3");
        countries.forEach(c->log.trace("{}",c));
        log.info("Total number of countries :{}",countries.size());
        log.info("END   testFindLikeName");
    }

    @Transactional
    @Test
          @DisplayName("Test get all Cities From a Country")
    void testGetAllCitiesFromACountry(){
        log.info("START testGetAllCitiesFromACountry ");
        Long countryId = 128L;
        int nbrCities = 35;
        Country country = countryService.getById(countryId); // 1er access DB
        assertNotNull(country, "Error While Read Country Id("+countryId+"");
        var cities = country.getCities(); //2eme access DB
        assertEquals(nbrCities, cities.size(), "ERROR Wrong number of Cities");
        cities.forEach(c -> log.trace("{}",c));
        log.info("Number Total of cities for country :{} {} = {}", country.getId(),cities.size());
        log.trace("END testGetAllCitiesFromACountry");
    }
}