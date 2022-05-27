package com.tnv.citysights.Sight;

import com.tnv.citysights.City.CityService;
import com.tnv.citysights.City.model.City;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SightsService {
    private final SightRepository sightRepository;
    private final CityService cityService;
    private final SightMapper sightMapper;

    public SightsService(SightRepository sightRepository, CityService cityService, SightMapper sightMapper) {
        this.sightRepository = sightRepository;
        this.cityService = cityService;
        this.sightMapper = sightMapper;
    }

    public Optional<Sight> getSightById(Long id) {
        return sightRepository.findById(id);
    }

    public void addSight(SightDto sightDto) {
        Sight sight = sightMapper.map(sightDto);
        sightRepository.save(sight);
    }

    public List<Sight> getAllSights(Optional<SightFilterCriteria> sightFilterCriteria) {
        if (!sightFilterCriteria.isPresent()) return sightRepository.findAll();
        Specification specification = Filter.getSpecification(sightFilterCriteria.get());
        return sightRepository.findAll(specification);
    }

    public List<Sight> getCitySights(Long id) {
        City city = cityService.getCityById(id);
        return sightRepository.findSightsByCity(city);
    }

    public void modifySight(ModifySightDto sightDto) {
        Sight sight = getSightById(sightDto.getId())
                .orElseThrow(() -> new IllegalStateException("There are no sight with such id"));
        sightMapper.map(sight, sightDto);
        sightRepository.save(sight);
    }

    public void deleteSight(Long id) {
        sightRepository.deleteById(id);
    }

}
