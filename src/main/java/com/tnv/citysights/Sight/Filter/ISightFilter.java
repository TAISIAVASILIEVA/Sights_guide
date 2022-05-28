package com.tnv.citysights.Sight.Filter;

import com.tnv.citysights.Sight.model.Sight;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

public interface ISightFilter {
    Specification<Sight> getSpecification(SightFilterCriteria condition);
    Sort getSort(SightFilterCriteria condition);
}
