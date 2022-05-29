package com.tnv.citysights.City.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import com.tnv.citysights.Sight.model.Sight;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

// TODO: 28.05.2022 Сделать валидацию
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private Long population;

    @NonNull
    private Boolean subwayAvailability;

    @NotNull
    private String country;

    @OneToMany(mappedBy = "city")
    @JsonIgnore
    private List<Sight> sights;

    public City(Long id, @NonNull String name, @NonNull Long population, @NonNull Boolean subwayAvailability, String country) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.subwayAvailability = subwayAvailability;
        this.country = country;
    }

    public City() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public Long getPopulation() {
        return population;
    }

    public void setPopulation(@NonNull Long population) {
        this.population = population;
    }

    @NonNull
    public Boolean getSubwayAvailability() {
        return subwayAvailability;
    }

    public void setSubwayAvailability(@NonNull Boolean subwayAvailability) {
        this.subwayAvailability = subwayAvailability;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Sight> getSights() {
        return sights;
    }

    public void setSights(List<Sight> sights) {
        this.sights = sights;
    }
}
