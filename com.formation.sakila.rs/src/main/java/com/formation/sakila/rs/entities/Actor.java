package com.formation.sakila.rs.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
	@Table(name="actor")
public class Actor {
	@Id
 		@GeneratedValue(strategy=GenerationType.IDENTITY) 
			@Column(name="actor_id")
	private Long id;
	
	@Column(name="first_name")
	private String firstName ;
	
	@Column(name="last_name")
	private String lastName ;
	
	@Column(name="last_update")
	private LocalDateTime lastUpdate;

	@ManyToMany   
		@JoinTable(name="film_actor",
			joinColumns={@JoinColumn(name="actor_id")},
			inverseJoinColumns={@JoinColumn(name="film_id")}) 
	private List<Film> films;
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
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
		return "Actor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", lastUpdate=" + lastUpdate
				+ "]";
	}
	
}
