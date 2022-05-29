package com.tnv.citysights.Sight.service;

import com.tnv.citysights.City.service.CityService;
import com.tnv.citysights.City.model.City;
import com.tnv.citysights.Sight.Filter.ISightFilter;
import com.tnv.citysights.Sight.Filter.SightFilterCriteria;
import com.tnv.citysights.Sight.repository.SightRepository;
import com.tnv.citysights.Sight.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SightService {
    private final SightRepository sightRepository;
    private final CityService cityService;
    private final SightMapper sightMapper;
    private final ISightFilter sightFilter;

    public SightService(SightRepository sightRepository, CityService cityService, SightMapper sightMapper, ISightFilter sightFilter) {
        this.sightRepository = sightRepository;
        this.cityService = cityService;
        this.sightMapper = sightMapper;
        this.sightFilter = sightFilter;
    }

    private Optional<Sight> getSightById(Long id) {
        return sightRepository.findById(id);
    }

    public void addSight(SightDto sightDto) {
        Sight sight = sightMapper.map(sightDto);
        sightRepository.save(sight);
        log.info(String.format("Sight with id %s was added", sight.getId()));
    }

    public List<Sight> getAllSights(Optional<SightFilterCriteria> sightFilterCriteria) {
        if (!sightFilterCriteria.isPresent()) return sightRepository.findAll();
        Specification<Sight> specification = sightFilter.getSpecification(sightFilterCriteria.get());
        if (sightFilterCriteria.get().getSortType() != null) {
            Sort sort = sightFilter.getSort(sightFilterCriteria.get());
            return sightRepository
                    .findAll(specification, sort);
        }
        return sightRepository.findAll(specification);
    }

    public List<Sight> getCitySights(Long id) {
        City city = cityService.getCityById(id);
        return city.getSights();
    }

    public void modifySight(Long id, ModifySightDto sightDto) {
        Optional<Sight> sight = getSightById(id);
        if (!sight.isPresent()) {
            log.error(String.format("There are no sight with id %s", id));
            throw new IllegalStateException("There are no sight with such id");
        }
        sightMapper.map(sight.get(), sightDto);
        sightRepository.save(sight.get());
        log.info(String.format("Sight with id %s was modified", id));
    }

    public void deleteSight(Long id) {
        sightRepository.deleteById(id);
        log.info(String.format("Sight with id %s was deleted", id));
    }

}
