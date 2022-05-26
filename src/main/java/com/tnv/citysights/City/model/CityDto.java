package com.tnv.citysights.City.model;

public class CityDto {

    private String name;

    private Long population;

    private Boolean subwayAvailability;

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
