package com.tnv.citysights.City;

import com.tnv.citysights.City.model.CityDto;
import com.tnv.citysights.City.model.ModifyCityDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/cities")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public ResponseEntity addCity(@Valid @RequestBody CityDto cityDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getFieldError().getDefaultMessage();
            log.error(message);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        cityService.addCity(cityDto);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity modifyCity(@PathVariable Long id, @Valid @RequestBody ModifyCityDto cityDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getFieldError().getDefaultMessage();
            log.error(message);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        cityService.modifyCity(id, cityDto);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
