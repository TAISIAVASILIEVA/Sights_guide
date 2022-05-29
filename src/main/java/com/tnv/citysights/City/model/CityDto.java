package com.tnv.citysights.City.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CityDto {

    @Schema(description = "Имя города")
    @NotBlank(message = "Необходимо указать название города")
    private String name;

    @Schema(description = "Численность населения")
    @NotNull(message = "Необходимо указать численность населения города")
    @Min(value = 0, message = "Численность населения не может быть меньше нуля")
    private Long population;

    @Schema(description = "Наличие метро")
    @NotNull(message = "Необходимо указать наличие метро")
    private Boolean subwayAvailability;

    @Schema(description = "Страна")
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
