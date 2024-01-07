package com.bms.BookMyShow.strategies;

import com.bms.BookMyShow.entities.Movies;
import com.bms.BookMyShow.entities.ShowSeats;
import com.bms.BookMyShow.enums.SeatType;
import com.bms.BookMyShow.execeptions.NoSuchMovie;
import com.bms.BookMyShow.repo.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SeatTypeStrategy implements PricingStrategy {

    @Autowired
    MoviesRepository moviesRepository;

    @Override
    public Double calculate(List<ShowSeats> showSeats) throws NoSuchMovie {
        Optional<Movies> m=moviesRepository.findById(showSeats.get(0).getShow().getBmsFunFacility_id());
        Double money=0.0d;
        if(m.isEmpty())
        {
            //throw error no movies
            throw new NoSuchMovie("No such movie exists");
        }

        for(ShowSeats seats: showSeats)
        {
            if(seats.getType()== SeatType.VIP)
                money+=m.get().getPricePerPerson()*4.0d;

            if(seats.getType()== SeatType.PLATINUM)
                money+=m.get().getPricePerPerson()*3.0d;

            if(seats.getType()== SeatType.GOLD)
                money+=m.get().getPricePerPerson()*2.0d;

            if(seats.getType()== SeatType.SILVER)
                money+=m.get().getPricePerPerson();
        }

        return money;
    }


}
