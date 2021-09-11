package com.formation.sboot.services;

import java.util.List;

import com.formation.sboot.entities.Country;

public interface CountryService {
	public List<Country> getAll();
	public List<Country> getAllNameLike(String likeName);
	public Country getById(Long id);
	public Country create(Country country);
	public Country update(Country country);
	public void delete(Long id);
}
