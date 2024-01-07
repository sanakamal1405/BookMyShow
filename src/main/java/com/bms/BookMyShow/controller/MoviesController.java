package com.bms.BookMyShow.controller;

import com.bms.BookMyShow.dtos.MovieDTO;
import com.bms.BookMyShow.entities.Movies;
import com.bms.BookMyShow.enums.Format;
import com.bms.BookMyShow.enums.Languages;
import com.bms.BookMyShow.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MoviesController {
    @Autowired
    MoviesService moviesService;

    @PostMapping(value="/movie",  produces="application/json", consumes = "application/json")
    public void addMovies(@RequestBody MovieDTO req)
    {

        moviesService.addMovies(req);

    }
}
