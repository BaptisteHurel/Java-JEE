package com.formation.sboot.jpa.film.entities;

import com.formation.sboot.jpa.film.converters.FeaturesConverter;
import com.formation.sboot.jpa.film.converters.RatingConverter;

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
	
	@Column(name="release_year")
	private Integer releaseYear ;

	
	@ManyToOne
		@JoinColumn(name="language_id")
	private Language language;
	
	@Column(name="original_language_id")
	private Integer originalLanguageId ;
	
	@Column(name="rental_rate")
	private BigDecimal rentalRate ;
	private Integer length;
	
	@Column(name="replacement_cost")
	private BigDecimal replacementCost ;
	
	@Convert(converter = RatingConverter.class)
	private Rating rating;
	
	@Column(name="special_features")
		@Convert(converter = FeaturesConverter.class)
	private List<String> specialFeatures ;
	
	@Column(name="last_update")
	private LocalDateTime lastUpdate;
	
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
	
	public Language getLanguage() {
		return language;
	}
    public void setLanguage(Language language) {
		this.language = language;
	}
	public Integer getOriginalLanguageId() {
		return originalLanguageId;
	}
	public void setOriginalLanguageId(Integer originalLanguageId) {
		this.originalLanguageId = originalLanguageId;
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
	
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	
	public List<String> getSpecialFeatures() {
		return specialFeatures;
	}
	public void setSpecialFeatures(List<String> specialFeatures) {
		this.specialFeatures = specialFeatures;
	}
	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Film{" +
				"id=" + id +
				", title='" + title + '\'' +
				", releaseYear=" + releaseYear +
				", language=" + language +
				", rentalRate=" + rentalRate +
				", length=" + length +
				", replacementCost=" + replacementCost +
				", rating=" + rating +
				", specialFeatures=" + specialFeatures +
				", lastUpdate=" + lastUpdate +
				'}';
	}
}
