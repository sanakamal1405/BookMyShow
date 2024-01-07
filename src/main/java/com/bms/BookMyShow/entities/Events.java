package com.bms.BookMyShow.entities;

import com.bms.BookMyShow.enums.Theme;
import com.bms.BookMyShow.enums.eventType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

@Entity

@SuperBuilder
public class Events extends BmsFunFacility{

    @Enumerated
    private eventType type;

    private String address;
}
