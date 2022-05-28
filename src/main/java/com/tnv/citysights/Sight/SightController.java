package com.tnv.citysights.Sight;

import com.tnv.citysights.Sight.model.ModifySightDto;
import com.tnv.citysights.Sight.model.Sight;
import com.tnv.citysights.Sight.model.SightDto;
import com.tnv.citysights.Sight.Filter.SightFilterCriteria;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sight")
public class SightController {

    private final SightService sightsService;

    public SightController(SightService sightsService) {
        this.sightsService = sightsService;
    }

    @PostMapping
    public void addSight(@RequestBody SightDto sightDto){
        sightsService.addSight(sightDto);
    }

    @GetMapping
    public List<Sight> getAllSights(@RequestBody(required=false) Optional<SightFilterCriteria> sightFilterCriteria){
        return sightsService.getAllSights(sightFilterCriteria);
    }

    @GetMapping("/city/{cityId}")
    public List<Sight> getCitySights(@PathVariable Long cityId){
        return sightsService.getCitySights(cityId);
    }

    // TODO: 27.05.2022 возможно изменить модифайдто, передавать id через pathvariable
    @PatchMapping
    public void modifySight(@RequestBody ModifySightDto sightDto){
        sightsService.modifySight(sightDto);
    }

    // TODO: 27.05.2022 возможно тоже pathvariable 
    @DeleteMapping
    public void deleteSight(Long id){
        sightsService.deleteSight(id);
    }
}
