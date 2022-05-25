package com.tnv.citysights;

import javax.persistence.*;
import java.util.List;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long population;

    private Boolean subwayAvailability;

    private String country;

    @OneToMany
    private List<Sight> sights;
}
