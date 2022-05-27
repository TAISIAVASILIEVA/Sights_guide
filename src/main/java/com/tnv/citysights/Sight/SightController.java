package com.tnv.citysights.Sight;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sight")
public class SightController {

    private final SightsService sightsService;

    public SightController(SightsService sightsService) {
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
