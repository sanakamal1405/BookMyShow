package com.bms.BookMyShow.entities;

import com.bms.BookMyShow.enums.SeatType;
import com.bms.BookMyShow.enums.seatStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class ShowSeats extends BaseModel {

    private int rowNo;

    private  int columnNo;

    @Enumerated
    private  SeatType type;

    @Enumerated
    private seatStatus status;

    @ManyToOne
    @JoinColumn(name = "show_id")
    @JsonBackReference
    private  Shows show;

    @ManyToOne
    @JoinColumn(name="ticket_id")
    private Tickets ticket;

}
