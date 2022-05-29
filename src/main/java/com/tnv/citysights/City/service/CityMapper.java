package com.tnv.citysights.City.service;

import com.tnv.citysights.City.model.City;
import com.tnv.citysights.City.model.CityDto;
import com.tnv.citysights.City.model.ModifyCityDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class CityMapper {


    @Mapping(target = "name", source = "cityDto.name")
    @Mapping(target = "population", source = "cityDto.population")
    @Mapping(target = "subwayAvailability", source = "cityDto.subwayAvailability")
    @Mapping(target = "country", source = "cityDto.country")
    public abstract City map(CityDto cityDto);

    @Mapping(target = "subwayAvailability", source = "cityDto.subwayAvailability")
    @Mapping(target = "population", source = "cityDto.population")
    public abstract void map(@MappingTarget City city, ModifyCityDto cityDto);

}
