package com.tnv.citysights;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Sight {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private LocalDate dateOfConstruction;

    private String description;

    private SightType type;

    @ManyToOne
    private City city;

}
