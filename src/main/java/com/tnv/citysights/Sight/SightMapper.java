package com.tnv.citysights.Sight;

import com.tnv.citysights.City.CityService;
import com.tnv.citysights.City.model.City;
import com.tnv.citysights.City.model.ModifyCityDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class SightMapper {

    @Autowired
    protected CityService cityService;

    @Mapping(target = "name", source = "sightDto.name")
    @Mapping(target = "dateOfConstruction", source = "sightDto.dateOfConstruction")
    @Mapping(target = "description", source = "sightDto.description")
    @Mapping(target = "type", source = "sightDto.type")
    @Mapping(target = "city", expression = "java(cityService.getCityById(sightDto.getCityId()))")
    public abstract Sight map(SightDto sightDto);

    public void map(@MappingTarget Sight sight, ModifySightDto sightDto) {
        sight.setDescription(sightDto.getDescription());
    }
}
