package com.tnv.citysights.Sight.model;

import javax.validation.constraints.NotNull;

public class ModifySightDto {

    @NotNull
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
