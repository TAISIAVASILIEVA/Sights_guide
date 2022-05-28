package com.tnv.citysights.City;

import com.tnv.citysights.City.model.City;
import com.tnv.citysights.City.model.CityDto;
import com.tnv.citysights.City.model.ModifyCityDto;
import com.tnv.citysights.Sight.SightService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
// TODO: 27.05.2022  add Class for paths
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

    @PatchMapping
    public void modifyCity(@RequestBody ModifyCityDto cityDto) {
        cityService.modifyCity(cityDto);
    }

    @GetMapping
    public City getCity(@RequestBody City city){
        return city;
    }


}
