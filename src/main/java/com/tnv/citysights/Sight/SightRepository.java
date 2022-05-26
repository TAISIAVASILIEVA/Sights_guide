package com.tnv.citysights.Sight;

import com.tnv.citysights.City.model.City;
import com.tnv.citysights.Sight.Sight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SightRepository extends JpaRepository<Sight, Long> {

    List<Sight> findSightsByCity(City city);

    Sight getById(Long id);
}
