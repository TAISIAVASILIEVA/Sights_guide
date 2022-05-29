package com.tnv.citysights.Sight;

import com.tnv.citysights.Sight.model.ModifySightDto;
import com.tnv.citysights.Sight.model.Sight;
import com.tnv.citysights.Sight.model.SightDto;
import com.tnv.citysights.Sight.Filter.SightFilterCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.metamodel.Bindable;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/sights")
public class SightController {

    private final SightService sightsService;

    public SightController(SightService sightsService) {
        this.sightsService = sightsService;
    }

    @PostMapping
    public ResponseEntity addSight(@Valid @RequestBody SightDto sightDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getFieldError().getDefaultMessage();
            log.error("Запрос");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        sightsService.addSight(sightDto);
        return new ResponseEntity(HttpStatus.ACCEPTED);
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
