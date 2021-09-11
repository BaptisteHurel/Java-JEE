package com.formation.sboot.jpa.film.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
	@Table(name="language")
public class Language {
	@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY) 
			@Column(name="language_id")
	private Long id;
	
	private String name;
	
	@Column(name="last_update")
	private LocalDateTime lastUpdate;
	
	@OneToMany(fetch = FetchType.LAZY)
		@JoinColumn(name="language_id") 
	private List<Film> films;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "Language [id=" + id + ", name=" + name + ", lastUpdate=" + lastUpdate + "]";
	}

}
