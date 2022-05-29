package com.tnv.citysights.Sight.Filter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.tnv.citysights.Sight.SightType;
import com.tnv.citysights.Sight.model.SortType;

public class SightFilterCriteria {
    SortType sortType;
    SightType sightType;

    public SightFilterCriteria(SortType sortType, SightType sightType) {
        this.sortType = sortType;
        this.sightType = sightType;
    }

    public SightFilterCriteria() {
    }

    public SortType getSortType() {
        return sortType;
    }

    public void setSortType(SortType sortType) {
        this.sortType = sortType;
    }

    public SightType getSightType() {
        return sightType;
    }

    public void setSightType(SightType sightType) {
        this.sightType = sightType;
    }
}
