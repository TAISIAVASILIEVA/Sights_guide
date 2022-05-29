package com.tnv.citysights.Sight.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;

public class ModifySightDto {

    @Schema(description = "Описание достопримечательности")
    @NotNull(message = "Необходимо заполнить описание")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
