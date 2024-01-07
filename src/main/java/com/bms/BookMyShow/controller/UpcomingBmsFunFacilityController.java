package com.bms.BookMyShow.controller;

import com.bms.BookMyShow.entities.Movies;
import com.bms.BookMyShow.repo.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

@RestController
public class UpcomingBmsFunFacilityController {

    @Autowired
    MoviesRepository moviesRepository;


    private Date date = new Date(System.currentTimeMillis() - 7L * 24 * 3600 * 1000);
//    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");




    @GetMapping(value="/latest-movies",  produces="application/json")
    public List<Movies> getLatestMovies()
    {
        return moviesRepository.findAllLatestMovies(date);
    }
}
