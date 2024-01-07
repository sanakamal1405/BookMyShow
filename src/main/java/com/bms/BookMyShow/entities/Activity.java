package com.bms.BookMyShow.entities;

import com.bms.BookMyShow.enums.Theme;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Date;

@Entity

@SuperBuilder

@NoArgsConstructor
public class Activity extends BmsFunFacility{

    @Enumerated
    private Theme theme;

    private String address;

    private Date eventDate;
}
