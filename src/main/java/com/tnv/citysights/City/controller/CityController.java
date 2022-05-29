package com.tnv.citysights.City.controller;

import com.tnv.citysights.City.model.CityDto;
import com.tnv.citysights.City.model.ModifyCityDto;
import com.tnv.citysights.City.service.CityService;
import com.tnv.citysights.Util.ValidException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/cities")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public void addCity(@Valid @RequestBody CityDto cityDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) throw new ValidException(bindingResult);
        cityService.addCity(cityDto);
    }

    @PatchMapping("/{id}")
    public void modifyCity(@PathVariable Long id, @RequestBody ModifyCityDto cityDto, BindingResult bindingResult) {
        cityService.modifyCity(id, cityDto);
    }
}
