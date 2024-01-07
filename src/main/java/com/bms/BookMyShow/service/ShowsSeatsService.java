package com.bms.BookMyShow.service;

import com.bms.BookMyShow.entities.ShowSeats;
import com.bms.BookMyShow.repo.ShowsSeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowsSeatsService {

    @Autowired
    private ShowsSeatsRepository showsSeatsRepository;

    public List<ShowSeats> findAllById(List<Long> l)
    {
        return showsSeatsRepository.findAllById(l);
    }

    public void saveAll(List<ShowSeats> showSeats) {

        showsSeatsRepository.saveAll(showSeats);
    }

    public void save(ShowSeats seat)
    {
        showsSeatsRepository.save(seat);
    }


}


