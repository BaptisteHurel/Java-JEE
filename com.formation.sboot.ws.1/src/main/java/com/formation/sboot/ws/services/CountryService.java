package com.formation.sboot.ws.services;

import com.formation.sboot.ws.entities.Country;

import java.util.List;


public interface CountryService {
	public List<Country> getAll();
	public List<Country> getAllNameLike(String likeName);
	public Country getById(Long id);
	public Country create(Country country);
	public Country update(Country country);
	public void delete(Long id);
}
