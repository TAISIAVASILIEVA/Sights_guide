package com.tnv.citysights.Sight.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tnv.citysights.City.model.City;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Sight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Название достопримечательности")
    private String name;

    @Schema(description = "Дата постройки")
    private LocalDate dateOfConstruction;


    @Schema(description = "Описание")
    private String description;

    @Schema(description = "Тип")
    @Enumerated(EnumType.STRING)
    private SightType type;

    @Schema(description = "Город")
    @ManyToOne
    @JoinColumn(nullable = false,
            name = "city_id")
    private City city;

    public Sight() {
    }

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

    public LocalDate getDateOfConstruction() {
        return dateOfConstruction;
    }

    public void setDateOfConstruction(LocalDate dateOfConstruction) {
        this.dateOfConstruction = dateOfConstruction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SightType getType() {
        return type;
    }

    public void setType(SightType type) {
        this.type = type;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
