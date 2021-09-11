package com.formation.thyme.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
    @Table(name="city")
public class City {
    @Id
        @Column(name = "city_id")
            @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String city;

    // Lazy  -> Les associations NE SONT PAS résolues au momment de l'accès sur l'entité
    // Eager -> Les associations sont résolues au momment de l'accès sur l'entité

    @ManyToOne
        @JoinColumn(name="country_id")
    private Country country;

    private Boolean capital;

    @Column(name="last_update")
    private LocalDateTime lastUpdate;

    public Long getId() {
        return id;
    }

    public City setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCity() {
        return city;
    }

    public City setCity(String city) {
        this.city = city;
        return this;
    }

    public Boolean getCapital() {
        return capital;
    }

    public City setCapital(Boolean capital) {
        this.capital = capital;
        return this;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public City setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public City setCountry(Country country) {
        this.country = country;
        return this;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", country=" + country +
                ", capital=" + capital +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
