package com.bms.BookMyShow.controller;

import com.bms.BookMyShow.dtos.CitiesDTO;
import com.bms.BookMyShow.entities.Cities;
import com.bms.BookMyShow.service.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitiesController {

    @Autowired
    CitiesService citiesService;

    @PostMapping(value="/cities", consumes = "application/json")
    public void save(@RequestBody CitiesDTO city)
    {
        citiesService.save(city);
    }
}
