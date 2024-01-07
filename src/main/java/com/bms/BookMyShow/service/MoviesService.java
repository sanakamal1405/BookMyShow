package com.bms.BookMyShow.service;

import com.bms.BookMyShow.dtos.MovieDTO;
import com.bms.BookMyShow.entities.Movies;
import com.bms.BookMyShow.repo.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;

import static com.bms.BookMyShow.entities.Movies.*;

@Service
public class MoviesService {

    @Autowired
    MoviesRepository moviesRepository;
    public void addMovies(MovieDTO req)
    {
//        Movies m= new Movies();
//        m.setFormat(req.getFormat());
//        m.setGenre(req.getGenre());
//        m.setLang(req.getLang());
//        m.setRating(req.getRating());
//        m.setTitle(req.getTitle());
//        m.setDescription(req.getDescription());
//        m.setPricePerPerson(req.getPricePerPerson());
//        m.setReleaseDate(req.getReleaseDate());

//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");

                Movies m=Movies.builder()
                .format(req.getFormat())
                .genre(req.getGenre())
                .lang(req.getLang())
                .rating(req.getRating())
                .description(req.getDescription())
                .pricePerPerson(req.getPricePerPerson())
                .title(req.getTitle())
                .releaseDate(Date.valueOf(req.getReleaseDate()))
                .build();

        moviesRepository.save(m);
    }
}
