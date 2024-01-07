package com.bms.BookMyShow.service;

import com.bms.BookMyShow.dtos.ShowsDTO;
import com.bms.BookMyShow.entities.ShowSeats;
import com.bms.BookMyShow.entities.Shows;
import com.bms.BookMyShow.enums.SeatType;
import com.bms.BookMyShow.enums.seatStatus;
import com.bms.BookMyShow.repo.ShowsRepository;
import com.bms.BookMyShow.repo.ShowsSeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
public class ShowsService {
    @Autowired
    private ShowsRepository showsRepository;

    @Autowired
    ShowsSeatsRepository showsSeatsRepository;
    private Shows show;

    public void save(ShowsDTO req)
    {

        Shows showWithoutSeat= Shows.builder()
                .bmsFunFacility_id(req.getBmsFunFacilityId())
                .startDate(Date.valueOf(req.getStartDate()))
                .startTime(req.getStartTime())
                .build();
        showsRepository.save(showWithoutSeat);  //insert

        //Create show seats
        List<ShowSeats> list=createShowSeats(showWithoutSeat);


        //Add seat to the show

        Shows showWithSeat= showWithoutSeat.toBuilder()
                .seats(list)
                .build();

                showsRepository.save(showWithSeat); //insert show seat & update

    }

    private List<ShowSeats> createShowSeats(Shows show) {
        //create different size seats on basis of theatre location via strategy pattern
        List<ShowSeats> list=new ArrayList<>();

        for(int i=0;i<10;i++)
        {
            list.add(ShowSeats.builder()
                    .type(SeatType.GOLD)
                    .columnNo(i+1)
                    .status(seatStatus.AVAILABLE)
                    .rowNo(1)
                            .show(show)
                    .build()
            );
        }

        for(int i=0;i<10;i++)
        {
            list.add(ShowSeats.builder()

                    .type(SeatType.VIP)
                            .status(seatStatus.AVAILABLE)
                    .columnNo(i+1)
                    .rowNo(2)
                            .show(show)
                    .build()
            );
        }

        return list;
    }

    public List<Shows> getShows() {

        List<Shows> shows = new ArrayList<>();
        Iterable<Shows> showsAll = showsRepository.findAll();
        for (Shows show : showsAll) {
            shows.add(show);
        }

        return shows;
    }
}
