package com.formation.sakila.rs.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
	@Table(name="film")
public class Film {

	@Id
		@Column(name="film_id")
			@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	private String title;

	private String description;
	
	@Column(name="release_year")
	private Integer releaseYear ;
	
	@Column(name="language_id")
	private Long languageId ;

	@Column(name="rental_rate")
	private BigDecimal rentalRate ;

	private Integer length;
	
	@Column(name="replacement_cost")
	private BigDecimal replacementCost ;

	@Column(name="last_update")
	private LocalDateTime lastUpdate;
	
	@ManyToMany(mappedBy="films") 
	private List<Actor> actors;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}
	

	public BigDecimal getRentalRate() {
		return rentalRate;
	}
	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public BigDecimal getReplacementCost() {
		return replacementCost;
	}
	public void setReplacementCost(BigDecimal replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getDescription() {
		return description;
	}

	public Film setDescription(String description) {
		this.description = description;
		return this;
	}

	public Long getLanguageId() {
		return languageId;
	}

	public Film setLanguageId(Long languageId) {
		this.languageId = languageId;
		return this;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public List<Actor> getActors() {
		return actors;
	}
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
		return "Film{" +
				"id=" + id +
				", title='" + title + '\'' +
				", releaseYear=" + releaseYear +
				", languageId=" + languageId +
				", rentalRate=" + rentalRate +
				", length=" + length +
				", replacementCost=" + replacementCost +
				", lastUpdate=" + lastUpdate +
				'}';
	}
}
