package com.tnv.citysights.City.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ModifyCityDto {

    @NotNull(message = "Необходимо указать численность населения города")
    @Min(value = 0, message = "Численность населения не может быть меньше нуля")
    private Long population;

    @NotNull(message = "Необходимо указать наличие метро")
    private Boolean subwayAvailability;

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
}
