package com.formation.sboot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.formation.sboot.entities.Country;
import com.formation.sboot.repositories.CountryRepository;


@Service
public class CountryServiceImpl implements CountryService {

	private CountryRepository repo ;

	public CountryServiceImpl(CountryRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Country> getAll() {
		return repo.findAll();
	}

	@Override
	public List<Country> getAllNameLike(String likeName) {
		return repo.findByNameLike(likeName);
	}

	@Override
	public Country getById(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Country create(Country country) {
		return repo.save(country);
	}

	@Override
	public Country update(Country country) {
		return repo.saveAndFlush(country);
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
