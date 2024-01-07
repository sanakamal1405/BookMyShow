package com.bms.BookMyShow.entities;

import com.bms.BookMyShow.enums.Mode;
import com.bms.BookMyShow.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity

@SuperBuilder(toBuilder = true)
@Data
@Getter
@NoArgsConstructor
public class Payments extends BaseModel {

    String referenceNum;
    Double amount;
    Mode mode;
    PaymentStatus status;

    @ManyToOne
    @JoinColumn(name="ticket_id")
    Tickets ticket;
}
