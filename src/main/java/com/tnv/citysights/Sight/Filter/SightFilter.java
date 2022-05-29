package com.tnv.citysights.Sight.Filter;

import com.tnv.citysights.Sight.model.Sight;
import com.tnv.citysights.Sight.model.SortType;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class SightFilter implements ISightFilter{

    @Override
    public Specification<Sight> getSpecification(SightFilterCriteria condition) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (condition.getSightType() != null) {
                predicates.add(criteriaBuilder.equal(root.get("type"), condition.getSightType()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

    @Override
    public Sort getSort(SightFilterCriteria condition) {
        return condition.getSortType().equals(SortType.ASCEND) ?
                Sort.by(Sort.Direction.ASC, "name") : Sort.by(Sort.Direction.DESC, "name");
    }

}
