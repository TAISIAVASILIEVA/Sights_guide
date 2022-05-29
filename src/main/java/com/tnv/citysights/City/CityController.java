package com.tnv.citysights.City;

import com.tnv.citysights.City.model.City;
import com.tnv.citysights.City.model.CityDto;
import com.tnv.citysights.City.model.ModifyCityDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public void addCity(@RequestBody CityDto cityDto) {
        System.out.println(cityDto.getName());
        cityService.addCity(cityDto);
    }

    @PatchMapping("/{id}")
    public void modifyCity(@PathVariable Long id, @RequestBody ModifyCityDto cityDto) {
        cityService.modifyCity(id, cityDto);
    }
}
