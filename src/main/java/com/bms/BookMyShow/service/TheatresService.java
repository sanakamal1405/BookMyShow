package com.bms.BookMyShow.service;

import com.bms.BookMyShow.dtos.TheatresDTO;
import com.bms.BookMyShow.entities.ShowSeats;
import com.bms.BookMyShow.entities.Shows;
import com.bms.BookMyShow.entities.Theatres;
import com.bms.BookMyShow.repo.ShowsRepository;
import com.bms.BookMyShow.repo.TheatresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatresService {

    @Autowired
    private TheatresRepository theatresRepository;

    @Autowired
    private ShowsRepository showsRepository;

    @Transactional
    public void saveTheatres(TheatresDTO req)
    {

        Theatres theatres=Theatres.builder()
                        .address(req.getAddress())
                                        .build();

        theatresRepository.save(theatres);

        //update seats add theatres id via seats id

        updateTheatresInShows(req.getShowsId(), theatres);


    }



    public List<Theatres> getTheatres() {

        List<Theatres> t=new ArrayList<>();

        Iterable<Theatres> theatres=theatresRepository.findAll();
        for(Theatres theatre: theatres)
        {
            t.add(theatre);
        }
        return  t;
    }

    //updateSeats(){ //fetch seat by ID add theatre_id}
    private void updateTheatresInShows(List<Long> showsId, Theatres theatres) {

        Iterable<Shows> se=showsRepository.findAllById(showsId);
        List<Shows> show = new ArrayList<>();
        for(Shows s:se)
        {
            s.toBuilder().theatres(theatres).build();
            showsRepository.save(s);
        }
    }

}
