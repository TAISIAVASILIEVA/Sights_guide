package com.tnv.citysights.City.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CityDto {

    @NotBlank(message = "Необходимо указать название города")
    private String name;

    @NotNull
    @Min(value = 0, message = "Численность населения не может быть меньше нуля")
    private Long population;

    @NotNull
    private Boolean subwayAvailability;

    @NotBlank(message = "Необходимо указать страну")
    private String country;

    public CityDto(String name, Long population, Boolean subwayAvailability, String country) {
        this.name = name;
        this.population = population;
        this.subwayAvailability = subwayAvailability;
        this.country = country;
    }

    public CityDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Boolean getSubwayAvailability() {
        return subwayAvailability;
    }

    public void setSubwayAvailability(Boolean subwayAvailability) {
        this.subwayAvailability = subwayAvailability;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
