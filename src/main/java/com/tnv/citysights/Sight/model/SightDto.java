package com.tnv.citysights.Sight.model;

import com.tnv.citysights.Sight.SightType;

import java.time.LocalDate;

public class SightDto {
    private String name;

    private LocalDate dateOfConstruction;

    private String description;

    private SightType type;

    private Long cityId;

    public SightDto() {
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

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}
