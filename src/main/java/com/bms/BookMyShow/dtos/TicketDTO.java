package com.bms.BookMyShow.dtos;

import com.bms.BookMyShow.entities.Payments;
import com.bms.BookMyShow.entities.ShowSeats;
import com.bms.BookMyShow.enums.Mode;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Data
public class TicketDTO {

    private List<Long> seatId;
    private Mode mode;

}
