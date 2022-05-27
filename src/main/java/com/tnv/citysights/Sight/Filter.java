package com.tnv.citysights.Sight;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Filter {

    public static Specification<Sight> getSpecification(SightFilterCriteria condition) {
        return new Specification<Sight>() {
            public Predicate toPredicate(Root<Sight> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (condition.getSortType() != null) {
                    switch (condition.getSortType()) {
                        case ACSEND -> predicates.add((Predicate) criteriaBuilder.asc(root.get("name")));
                        case DESCEND -> predicates.add((Predicate) criteriaBuilder.desc(root.get("name")));
                    }
                }
                if (condition.getSightType() != null) {
                    predicates.add((Predicate) criteriaBuilder.equal(root.get("type"), condition.getSightType()));
                }
                Predicate[] pre = new Predicate[predicates.size()];
                return criteriaBuilder.and(predicates.toArray(pre));
            }
        };
    }
}
