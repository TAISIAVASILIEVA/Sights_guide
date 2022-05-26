package com.tnv.citysights.Sight;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Sight> getAllSights(){
        return sightsService.getAllSights();
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
