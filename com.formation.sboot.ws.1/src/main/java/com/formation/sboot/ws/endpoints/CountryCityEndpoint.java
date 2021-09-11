package com.formation.sboot.ws.endpoints;


import com.formation.sboot.soap.GetAllCountriesResponse;
import com.formation.sboot.ws.mappers.CountryMapper;
import com.formation.sboot.ws.entities.Country;
import com.formation.sboot.ws.services.CityService;
import com.formation.sboot.ws.services.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Endpoint
public class CountryCityEndpoint {
    private final static Logger log = LoggerFactory.getLogger(CountryCityEndpoint.class);

    private static final String NAMESPACE_URI = "http://www.formation.com/sboot/soap";

    private CountryService countryService;

    private CityService cityService;

    public CountryCityEndpoint(CountryService countryService, CityService cityService) {
        this.countryService = countryService;
        this.cityService = cityService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI,
            localPart = "GetAllCountriesRequest")
    @ResponsePayload
    public GetAllCountriesResponse getAllCountries(){
        log.trace("getAllCountry Endpoint called ...");
        var countries = countryService.getAll();
        var types = countries.stream().map(CountryMapper::toType).collect(Collectors.toList());
        GetAllCountriesResponse response = new GetAllCountriesResponse();
        response.getCountryType().addAll(types);
        return response;
    }

}
