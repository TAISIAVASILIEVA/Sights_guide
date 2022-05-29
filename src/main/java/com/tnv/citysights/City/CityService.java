package com.tnv.citysights.City;

import com.tnv.citysights.City.model.City;
import com.tnv.citysights.City.model.CityDto;
import com.tnv.citysights.City.model.ModifyCityDto;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public CityService(CityRepository cityRepository, CityMapper cityMapper) {
        this.cityRepository = cityRepository;
        this.cityMapper = cityMapper;
    }

    public void addCity(CityDto city) {
        cityRepository.save(cityMapper.map(city));
    }

    public City getCityById(Long id) {
        return cityRepository.findById(id).orElseThrow(()-> new IllegalStateException("There are no city with such id"));
    }

    public void modifyCity(Long id, ModifyCityDto cityDto) {
        City city = getCityById(id);
        cityMapper.map(city, cityDto);
        cityRepository.save(city);
    }
}
