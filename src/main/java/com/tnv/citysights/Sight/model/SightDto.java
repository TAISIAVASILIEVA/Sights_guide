package com.tnv.citysights.Sight.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class SightDto {

    @Schema(description = "Название достопримечательности")
    @NotBlank(message = "Необходимо указать название")
    private String name;

    @Schema(description = "Дата постройки")
    @PastOrPresent
    @NotNull(message = "Необходимо указать дату постройки")
    private LocalDate dateOfConstruction;

    @Schema(description = "Описание")
    @NotNull(message = "Необходимо заполнить описание")
    private String description;

    @Schema(description = "Тип")
    @NotNull(message = "Неободимо указать тип достопримечательности")
    private SightType type;

    @Schema(description = "Город")
    @NotNull(message = "Необходимо указать город")
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
