package com.bms.BookMyShow.controller;

import com.bms.BookMyShow.dtos.TicketDTO;
import com.bms.BookMyShow.entities.Tickets;
import com.bms.BookMyShow.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping(value="/book",  produces="application/json", consumes = "application/json")
    public void bookTicket(@RequestBody TicketDTO req) throws Exception {
         bookingService.book(req);
    }
}
