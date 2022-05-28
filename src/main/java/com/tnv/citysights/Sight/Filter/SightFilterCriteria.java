package com.tnv.citysights.Sight.Filter;

import com.tnv.citysights.Sight.SightType;
import com.tnv.citysights.Sight.model.SortType;

public class SightFilterCriteria {
    SortType nameSortType;
    SightType sightType;

    public SortType getNameSortType() {
        return nameSortType;
    }

    public void setNameSortType(SortType nameSortType) {
        this.nameSortType = nameSortType;
    }

    public SightType getSightType() {
        return sightType;
    }

    public void setSightType(SightType sightType) {
        this.sightType = sightType;
    }
}
