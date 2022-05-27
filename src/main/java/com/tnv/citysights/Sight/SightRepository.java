package com.tnv.citysights.Sight;

import com.tnv.citysights.City.model.City;
import com.tnv.citysights.Sight.Sight;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Predicate;
import java.util.List;

@Repository
public interface SightRepository extends JpaRepository<Sight, Long>, JpaSpecificationExecutor<Sight> {

    List<Sight> findSightsByCity(City city);

    Sight getById(Long id);

    List<Sight> findAll(Specification<Sight> specification);
}
