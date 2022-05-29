package com.tnv.citysights.Sight.controller;

import com.tnv.citysights.Sight.Filter.SightFilterCriteria;
import com.tnv.citysights.Sight.model.ModifySightDto;
import com.tnv.citysights.Sight.model.Sight;
import com.tnv.citysights.Sight.model.SightDto;
import com.tnv.citysights.Sight.service.SightService;
import com.tnv.citysights.Util.ValidException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sights")
public class SightController {

    private final SightService sightsService;

    public SightController(SightService sightsService) {
        this.sightsService = sightsService;
    }

    @PostMapping
    public void addSight(@Valid @RequestBody SightDto sightDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) throw new ValidException(bindingResult);
        sightsService.addSight(sightDto);
    }

    @GetMapping
    public List<Sight> getAllSights(@RequestBody(required = false) Optional<SightFilterCriteria> sightFilterCriteria) {
        return sightsService.getAllSights(sightFilterCriteria);
    }

    @GetMapping("/city/{cityId}")
    public List<Sight> getCitySights(@PathVariable Long cityId) {
        return sightsService.getCitySights(cityId);
    }

    @PatchMapping("/{id}")
    public void modifySight(@PathVariable Long id, @Valid @RequestBody ModifySightDto sightDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) throw new ValidException(bindingResult);
        sightsService.modifySight(id, sightDto);
    }

    @DeleteMapping("/{id}")
    public void deleteSight(@PathVariable Long id) {
        sightsService.deleteSight(id);
    }
}
