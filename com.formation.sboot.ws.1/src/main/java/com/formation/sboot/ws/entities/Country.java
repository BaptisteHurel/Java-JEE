package com.formation.sboot.ws.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity 
	@Table(name = "country")
public class Country {
	
	@Id
		@Column(name="country_id")
			@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String country;
	
	@Column(name="last_update")
	private LocalDateTime lastUpdate;

	@OneToMany(mappedBy = "country")
	private List<City> cities;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public List<City> getCities() {
		return cities;
	}

	public Country setCities(List<City> cities) {
		this.cities = cities;
		return this;
	}


	@Override
	public String toString() {
		return "Country{" +
				"id=" + id +
				", country='" + country + '\'' +
				", lastUpdate=" + lastUpdate +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Country country1 = (Country) o;

		if (!id.equals(country1.id)) return false;
		if (!country.equals(country1.country)) return false;
		return lastUpdate.equals(country1.lastUpdate);
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + country.hashCode();
		result = 31 * result + lastUpdate.hashCode();
		return result;
	}
}
