package com.tnv.citysights.City.service;

import com.tnv.citysights.City.repository.CityRepository;
import com.tnv.citysights.City.model.City;
import com.tnv.citysights.City.model.CityDto;
import com.tnv.citysights.City.model.ModifyCityDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
public class CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public CityService(CityRepository cityRepository, CityMapper cityMapper) {
        this.cityRepository = cityRepository;
        this.cityMapper = cityMapper;
    }

    public void addCity(CityDto city) {
        cityRepository.save(cityMapper.map(city));
        log.info(String.format("City %s has been added", city.getName()));
    }

    public City getCityById(Long id) {
        Optional<City> city = cityRepository.findById(id);
        if (!city.isPresent()) {
            log.error(String.format("There is no city with id %s", id));
            throw new IllegalStateException(String.format("There is no city with id %s", id));
        }
        return city.get();
    }

    public void modifyCity(Long id, ModifyCityDto cityDto) {
        City city = getCityById(id);
        cityMapper.map(city, cityDto);
        cityRepository.save(city);
        log.info(String.format("City with id %s has been modified", city.getId()));
    }
}
