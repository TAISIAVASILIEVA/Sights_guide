package com.tnv.citysights.Sight.controller;

import com.tnv.citysights.Sight.Filter.SightFilterCriteria;
import com.tnv.citysights.Sight.model.ModifySightDto;
import com.tnv.citysights.Sight.model.Sight;
import com.tnv.citysights.Sight.model.SightDto;
import com.tnv.citysights.Sight.service.SightService;
import com.tnv.citysights.Util.ValidException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Tag(name = "Достопримечательности", description = "Позволяет добавлять, изменять и просматривать информацию о достоприечательностях")
@RestController
@RequestMapping("/sights")
public class SightController {

    private final SightService sightsService;

    public SightController(SightService sightsService) {
        this.sightsService = sightsService;
    }

    @Operation(summary = "Добавить достопримечательность")
    @PostMapping
    public void addSight(@Valid @RequestBody SightDto sightDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) throw new ValidException(bindingResult);
        sightsService.addSight(sightDto);
    }

    @Operation(summary = "Получить все достопримечательности")
    @GetMapping
    public List<Sight> getAllSights(@RequestBody(required = false) Optional<SightFilterCriteria> sightFilterCriteria) {
        return sightsService.getAllSights(sightFilterCriteria);
    }

    @Operation(summary = "Получить достопримечательности города")
    @GetMapping("/city/{cityId}")
    public List<Sight> getCitySights(@PathVariable Long cityId) {
        return sightsService.getCitySights(cityId);
    }

    @Operation(summary = "Изменить информацию о достопримечательности")
    @PatchMapping("/{id}")
    public void modifySight(@PathVariable Long id, @Valid @RequestBody ModifySightDto sightDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) throw new ValidException(bindingResult);
        sightsService.modifySight(id, sightDto);
    }

    @Operation(summary = "Удалить достопримечательность")
    @DeleteMapping("/{id}")
    public void deleteSight(@PathVariable Long id) {
        sightsService.deleteSight(id);
    }
}
