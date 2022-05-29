package com.tnv.citysights.Sight;

import com.tnv.citysights.Sight.model.ModifySightDto;
import com.tnv.citysights.Sight.model.Sight;
import com.tnv.citysights.Sight.model.SightDto;
import com.tnv.citysights.Sight.Filter.SightFilterCriteria;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public void addSight(@Valid @RequestBody SightDto sightDto) {
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
    public void modifySight(@PathVariable Long id, @Valid @RequestBody ModifySightDto sightDto) {
        sightsService.modifySight(id, sightDto);
    }

    @DeleteMapping("/{id}")
    public void deleteSight(@PathVariable Long id) {
        sightsService.deleteSight(id);
    }
}
