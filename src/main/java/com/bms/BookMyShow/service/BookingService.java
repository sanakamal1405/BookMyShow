package com.bms.BookMyShow.service;

import com.bms.BookMyShow.dtos.TicketDTO;
import com.bms.BookMyShow.entities.Payments;
import com.bms.BookMyShow.entities.ShowSeats;
import com.bms.BookMyShow.entities.Tickets;
import com.bms.BookMyShow.enums.BookingStatus;
import com.bms.BookMyShow.enums.PaymentStatus;
import com.bms.BookMyShow.enums.seatStatus;
import com.bms.BookMyShow.execeptions.NoSuchMovie;
import com.bms.BookMyShow.execeptions.SeatNotAvaiable;
import com.bms.BookMyShow.repo.BookingRepository;
import com.bms.BookMyShow.repo.PaymentsRepository;
import com.bms.BookMyShow.strategies.PricingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class BookingService {

    @Autowired
    ShowsSeatsService showsSeatsService;

    @Autowired
    PricingStrategy pricingStrategy;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    PaymentsRepository paymentsRepository;



    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void book(TicketDTO req) throws Exception {
        //Validate seat availability

            Iterable<ShowSeats> se=showsSeatsService.findAllById(req.getSeatId());
        List<ShowSeats> showSeats = new ArrayList<>();
        for(ShowSeats s:se)
        {
            showSeats.add(s);
        }

        if(!(showSeats.stream().filter(e -> e.getStatus() == seatStatus.AVAILABLE).collect(Collectors.toList()).size()==showSeats.size()))
        {
         //throw error
            throw new SeatNotAvaiable("Selected Seats Not available");
        // System.out.println("Selected Seats Not available");
        }

        // Locke the seats
        for(ShowSeats seat: showSeats)
        {
            seat.setStatus(seatStatus.LOCKED);
        }

        Tickets ticketsWithoutPayment=Tickets.builder()
                .seats(showSeats)
                .status(BookingStatus.WAITING)
                .build();

        //process payment

        Payments paymentWithoutAmount=Payments.builder()
                    .mode(req.getMode())
                    .referenceNum(((int)(System.currentTimeMillis()*Math.random()))+"")
                .status(PaymentStatus.PENDING)
                .build();

        Double amount = pricingStrategy.calculate(showSeats);
        Payments withPrice = paymentWithoutAmount.toBuilder().amount(amount).build();
         List<Payments> payments  =new ArrayList<>();
         payments.add(withPrice);


        for(ShowSeats seat: showSeats)
        {
            seat.setStatus(seatStatus.BOOKED);
        }


        //generateTicket
        Tickets ticket=ticketsWithoutPayment.toBuilder()
                .seats(showSeats)
                .status(BookingStatus.CONFIRMED)
                .payments(payments)
                .build();

        Tickets t=bookingRepository.save(ticket);



        //Map ticket to the seat

        for(ShowSeats seat: showSeats)
        {
            seat.setTicket(ticket);
        }

        showsSeatsService.saveAll(showSeats);




        //Map ticket to the payment  --
        Payments withPriceAndTicket = withPrice.toBuilder().ticket(t).build();

        List<Payments> paymentsWithTicket  =new ArrayList<>();
        paymentsWithTicket.add(withPriceAndTicket);

        paymentsRepository.saveAll(paymentsWithTicket);


    }
}
