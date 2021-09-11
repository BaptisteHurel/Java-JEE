package com.formation.sboot.ws.services;

import java.util.List;

import com.formation.sboot.ws.entities.Country;
import com.formation.sboot.ws.repositories.CountryRepository;
import org.springframework.stereotype.Service;


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
