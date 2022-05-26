package com.tnv.citysights.City;

import com.tnv.citysights.City.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City getById(Long id);
}
