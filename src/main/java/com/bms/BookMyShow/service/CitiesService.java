package com.bms.BookMyShow.service;

import com.bms.BookMyShow.dtos.CitiesDTO;
import com.bms.BookMyShow.entities.Cities;
import com.bms.BookMyShow.repo.CitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitiesService {
    @Autowired
    private CitiesRepository citiesRepository;

    public void save(CitiesDTO city){

        Cities cities = Cities.builder()
                .location(city.getLocation())
                                 .build();

        citiesRepository.save(cities);
    }
}
