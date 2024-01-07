package com.bms.BookMyShow.entities;

import com.bms.BookMyShow.enums.BookingStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity

@SuperBuilder(toBuilder = true)
@Data
@NoArgsConstructor
public class Tickets extends BaseModel{

    @OneToMany(mappedBy = "ticket",cascade=CascadeType.ALL)
    private List<ShowSeats> seats;

    @OneToMany(mappedBy = "ticket",cascade= CascadeType.ALL)
    List<Payments> payments;

    @Enumerated
    BookingStatus status;
}
